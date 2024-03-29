package cs.matemaster.web.bff.facade;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.Eg1QueryRequest;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.vo.SysUserVO;

import java.util.List;

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

    /**
     * 手动分页查询用户数据
     *
     * @return
     */
    PageDataView<SysUserDTO> getPagingList(QuerySysUserRequest request);

    /**
     * 并发查询用户信息
     *
     * @param capacity
     * @return
     */
    List<SysUserDTO> concurrentQuery(int capacity);
}
