package cs.matemaster.web.bff.facade;

import cs.matemaster.common.vo.SysUserVO;

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
}
