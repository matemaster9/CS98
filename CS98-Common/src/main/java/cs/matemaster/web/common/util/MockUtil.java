package cs.matemaster.web.common.util;

import cs.matemaster.web.common.dto.SysUserDTO;

import java.util.List;

/**
 * Mock数据
 *
 * @author MateMaster
 * @since 2022/7/19
 */
public class MockUtil {

    private static final int DEFAULT_CAPACITY = 10_000;

    private MockUtil() {
    }

    public static SysUserDTO getSysUserDTO() {
        return new SysUserDTO();
    }

    public static List<SysUserDTO> getSysUserDTOList() {
        return SysUserDTO.generate(DEFAULT_CAPACITY);
    }

    public static List<SysUserDTO> getSysUserDTOList(int capacity) {
        return SysUserDTO.generate(capacity);
    }
}
