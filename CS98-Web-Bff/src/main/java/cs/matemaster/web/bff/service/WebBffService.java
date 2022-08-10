package cs.matemaster.web.bff.service;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.vo.SysUserVO;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public interface WebBffService {

    /**
     * 调用API层获取随机用户信息
     *
     * @return
     */
    SysUserVO getRandomUserInfo();

    /**
     * 手动分页查询用户
     *
     * @param request
     * @return
     */
    PageDataView<SysUserDTO> getPagingList(QuerySysUserRequest request);

    /**
     * 并发查询
     *
     * @param capacity
     * @return
     */
    List<SysUserDTO> concurrentQuery(int capacity);
}
