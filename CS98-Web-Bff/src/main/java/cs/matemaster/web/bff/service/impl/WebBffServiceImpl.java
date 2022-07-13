package cs.matemaster.web.bff.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import cs.matemaster.web.common.constant.ErrorCode;
import cs.matemaster.web.common.dto.DataWrapperDTO;
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
}
