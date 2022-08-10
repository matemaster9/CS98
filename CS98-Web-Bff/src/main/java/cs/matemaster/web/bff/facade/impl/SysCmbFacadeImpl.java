package cs.matemaster.web.bff.facade.impl;

import cs.matemaster.web.bff.facade.SysCmbFacade;
import cs.matemaster.web.bff.model.syscmb.CsaDummyRequest;
import cs.matemaster.web.bff.model.syscmb.vo.CsaDummyDataVO;
import cs.matemaster.web.bff.service.SysCmbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
@Component
@AllArgsConstructor
public class SysCmbFacadeImpl implements SysCmbFacade {

    private SysCmbService sysCmbService;

    @Override
    public List<CsaDummyDataVO> queryDummyDataList(CsaDummyRequest request) {
        return null;
    }

    private void checkAndPreprocess(CsaDummyRequest request) {

    }
}
