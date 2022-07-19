package cs.matemaster.web.common.util;

import cs.matemaster.web.common.dto.SysUserDTO;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public static List<SysUserDTO> getData4SysUserDTO() {
        return SysUserDTO.generate(DEFAULT_CAPACITY);
    }
}
