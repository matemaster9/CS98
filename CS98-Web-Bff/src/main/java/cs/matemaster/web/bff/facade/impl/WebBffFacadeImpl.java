package cs.matemaster.web.bff.facade.impl;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.exception.WebRuntimeException;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.Eg1QueryRequest;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.common.webcore.BizUtil;
import cs.matemaster.web.bff.config.SysWebCfg;
import cs.matemaster.web.bff.constant.WebBffErrorCode;
import cs.matemaster.web.bff.facade.WebBffFacade;
import cs.matemaster.web.bff.service.WebBffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Component
@AllArgsConstructor
@Slf4j
public class WebBffFacadeImpl implements WebBffFacade {

    private WebBffService webBffService;
    private SysWebCfg sysWebCfg;

    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    @Override
    public SysUserVO getRandomUserInfo() {
        return webBffService.getRandomUserInfo();
    }

    @Override
    public void print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN);
        LocalDateTime parse = LocalDateTime.parse(sysWebCfg.getLocalQueryStartDate(), formatter);
        log.info(parse.toString());
    }

    @Override
    public void querySysWebCfg(Eg1QueryRequest request) {
        checkAndPreprocess(request);
        log.info(request.getStart());
        log.info(request.getEnd());
    }

    @Override
    public PageDataView<SysUserDTO> getPagingList(QuerySysUserRequest request) {
        if (request.getPageNo() < 1) {
            // throw err
        }

        if (request.getPageSize() < 0) {
            // throw err
        }

        return webBffService.getPagingList(request);
    }

    private void checkAndPreprocess(Eg1QueryRequest request) {
        var formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN);
        var localQueryStartDate = LocalDateTime.parse(sysWebCfg.getLocalQueryStartDate(), formatter);

        var reqStartDate = BizUtil.isEmptyOrBlank(request.getStart()) ? localQueryStartDate : LocalDateTime.parse(request.getStart(), formatter);
        var reqEndDate = BizUtil.isEmptyOrBlank(request.getEnd()) ? localQueryStartDate : LocalDateTime.parse(request.getEnd(), formatter);

        // 查询条件不可小于最小本地查询时间
        if (reqStartDate.isBefore(localQueryStartDate)) {
            request.setStart(sysWebCfg.getLocalQueryStartDate());
        }

        var yesterday = LocalDateTime.now().minusDays(1);

        if (reqStartDate.isAfter(yesterday)) {
            throw new WebRuntimeException(WebBffErrorCode.QUERY_DATE_ERROR);
        }

        // 结束时间不可超过当前时间
        if (reqEndDate.isAfter(yesterday)) {
            request.setEnd(yesterday.format(formatter));
        }
    }
}
