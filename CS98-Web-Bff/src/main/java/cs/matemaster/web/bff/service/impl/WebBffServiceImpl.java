package cs.matemaster.web.bff.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cs.matemaster.web.common.constant.ErrorCode;
import cs.matemaster.web.common.dto.DataWrapperDTO;
import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.vo.HttpResponseWrapperVO;
import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.common.webcore.BizUtil;
import cs.matemaster.web.common.webcore.JsonUtil;
import cs.matemaster.web.common.webcore.httpclient.HttpClientUtil;
import cs.matemaster.web.bff.config.SysBffConfig;
import cs.matemaster.web.bff.service.WebBffService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Service
@AllArgsConstructor
@Slf4j
public class WebBffServiceImpl implements WebBffService {

    private SysBffConfig sysBffConfig;

    private static final int QUERY_CAPACITY = 10000;
    private static final ExecutorService CONCURRENCY_SERVER = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            new ThreadFactoryBuilder().setNameFormat("query-service---%d").build());

    @Override
    public SysUserVO getRandomUserInfo() {
        String url = sysBffConfig.getWebApiUrl() + "/sys-user-config/rdmUser";

        var response = HttpClientUtil.doGet(url);
        var result = JsonUtil.deserialize(response.getData(), new TypeReference<DataWrapperDTO<SysUserVO>>() {
        });

        if (Objects.isNull(response)) {
            log.error("请求接口为空");
        }
        if (BizUtil.isFalse(Objects.equals(result.getCode(), ErrorCode.SUCCESS.getCode()))) {
            log.error("请求失败");
        }

        return result.getData();
    }

    @Override
    public PageDataView<SysUserDTO> getPagingList(QuerySysUserRequest request) {
        List<SysUserDTO> data = Lists.newArrayList();
        PageDataView<SysUserDTO> pageDataView = new PageDataView<>();

        // 获取数据
        List<SysUserDTO> data4SysUserDTO = MockUtil.getSysUserDTOList(1000);

        if (BizUtil.isEmptyColl(data4SysUserDTO)) {
            return null;
        }

        int totalCount = data4SysUserDTO.size();
        int maxPageNo = (int) Math.ceil((double) totalCount / request.getPageSize());
        int currentPageNo = Math.min(request.getPageNo(), maxPageNo);
        int startIndex = (currentPageNo - 1) * request.getPageSize();
        int endIndex = startIndex + request.getPageSize();

        if (endIndex < totalCount) {
            for (int i = startIndex; i < endIndex; i++) {
                data.add(data4SysUserDTO.get(i));
            }
        } else {
            for (int i = startIndex; i < totalCount; i++) {
                data.add(data4SysUserDTO.get(i));
            }
        }

        pageDataView.setData(data);
        pageDataView.setPageNo(currentPageNo);
        pageDataView.setTotalCount(totalCount);
        pageDataView.setPageSize(request.getPageSize());

        return pageDataView;
    }

    @Override
    public List<SysUserDTO> concurrentQuery(int capacity) {
        int count = capacity / QUERY_CAPACITY + 1;
        List<Future<List<SysUserDTO>>> futureList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                futureList.add(CONCURRENCY_SERVER.submit(new QuerySysUserDTOListTask(capacity - QUERY_CAPACITY * count)));
            } else {
                futureList.add(CONCURRENCY_SERVER.submit(new QuerySysUserDTOListTask(QUERY_CAPACITY)));
            }
        }

        List<SysUserDTO> resultList = new ArrayList<>();
        for (var item : futureList) {
            try {
                resultList.addAll(item.get());
            } catch (Exception e) {
                item.toString();
            }
        }
        return resultList;
    }

    @Data
    private class QuerySysUserDTOListTask implements Callable<List<SysUserDTO>> {
        private final int capacity;

        @Override
        public List<SysUserDTO> call() {
            String url = sysBffConfig.getWebApiUrl() + "/sys/getSysUserDTOList?capacity=" + getCapacity();
            var response = HttpClientUtil.doGet(url);
            var result = JsonUtil.deserialize(response.getData(), new TypeReference<DataWrapperDTO<List<SysUserDTO>>>() {
            });
            if (Objects.isNull(response)) {
                log.error("调取API接口失败");
            }

            if (Objects.nonNull(result) && StringUtils.equals(ErrorCode.SUCCESS.getMessage(), result.getCode())) {
                log.error("调取API接口失败");
            }
            return result.getData();
        }
    }
}
