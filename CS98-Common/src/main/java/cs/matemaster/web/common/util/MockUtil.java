package cs.matemaster.web.common.util;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.model.ComStaff;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Mock数据
 *
 * @author MateMaster
 * @since 2022/7/19
 */
public class MockUtil {

    private static final int DEFAULT_CAPACITY = 10_000;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

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

    public static List<ClubMember> getClubMemberList(int capacity) {
        return Stream.generate(ClubMember::new).limit(capacity).collect(Collectors.toList());
    }

    public static int[] getBinarySequence(int capacity) {
        return IntStream.iterate(1, x -> 2 * x).limit(Math.min(31, capacity)).toArray();
    }

    public static int[] getStochasticSequence(int origin, int bound, int capacity) {
        return RANDOM.ints(origin, bound).limit(capacity).toArray();
    }

    public static List<ComStaff> getComStaffList(int capacity) {
        return Stream.generate(ComStaff::new).limit(capacity).collect(Collectors.toList());
    }
}
