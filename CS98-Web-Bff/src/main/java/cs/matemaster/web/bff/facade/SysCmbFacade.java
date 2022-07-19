package cs.matemaster.web.bff.facade;

import cs.matemaster.web.bff.model.syscmb.CsaDummyRequest;
import cs.matemaster.web.bff.model.syscmb.vo.CsaDummyDataVO;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
public interface SysCmbFacade {

    /**
     * 依据条件查询虚拟数据
     *
     * @param request
     * @return
     */
    List<CsaDummyDataVO> queryDummyDataList(CsaDummyRequest request);
}
