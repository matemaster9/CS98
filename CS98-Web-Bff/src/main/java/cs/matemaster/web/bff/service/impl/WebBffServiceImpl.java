package cs.matemaster.web.bff.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import cs.matemaster.web.common.constant.ErrorCode;
import cs.matemaster.web.common.dto.DataWrapperDTO;
import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.common.webcore.BizUtil;
import cs.matemaster.web.common.webcore.JsonUtil;
import cs.matemaster.web.common.webcore.httpclient.HttpClientUtil;
import cs.matemaster.web.bff.config.SysBffConfig;
import cs.matemaster.web.bff.service.WebBffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Service
@AllArgsConstructor
@Slf4j
public class WebBffServiceImpl implements WebBffService {

    private SysBffConfig sysBffConfig;

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
        List<SysUserDTO> data4SysUserDTO = MockUtil.getData4SysUserDTO();

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
}
