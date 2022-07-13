package cs.matemaster.web.bff.facade;

import cs.matemaster.web.common.request.Eg1QueryRequest;
import cs.matemaster.web.common.vo.SysUserVO;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public interface WebBffFacade {

    /**
     * 调用API层获取随机用户信息
     *
     * @return
     */
    SysUserVO getRandomUserInfo();

    /**
     * 打印测试
     */
    void print();

    /**
     * 测试工作实践校验逻辑
     *
     * @param request
     */
    void querySysWebCfg(Eg1QueryRequest request);
}
