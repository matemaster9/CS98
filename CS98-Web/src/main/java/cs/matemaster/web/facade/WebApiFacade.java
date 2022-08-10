package cs.matemaster.web.facade;

import cs.matemaster.web.common.dto.SysUserDTO;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/24
 */
public interface WebApiFacade {


    List<SysUserDTO> getSysUserDTOList(int capacity);
}
