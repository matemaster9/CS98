package cs.matemaster.web.common.util;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.model.ComStaff;
import cs.matemaster.web.common.testmodel.DataFunnel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
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

    public static List<DataFunnel> getDataFunnelForTest(int capacity) {
        Supplier<DataFunnel> supplier = () -> {
            DataFunnel temp = new DataFunnel();
            temp.setDate(LocalDate.of(2022, RANDOM.nextInt(5,8), RANDOM.nextInt(1, 31)).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            temp.setVar1(RANDOM.nextInt(0, 100));
            temp.setVar2(RANDOM.nextInt(0, 100));
            temp.setVar3(RANDOM.nextInt(0, 100));
            temp.setVar4(RANDOM.nextInt(0, 100));
            temp.setVar5(RANDOM.nextInt(0, 100));
            temp.setVar6(RANDOM.nextInt(0, 100));
            temp.setVar7(BigDecimal.valueOf(RANDOM.nextDouble(0.0, 10000.0)));
            temp.setVar8(BigDecimal.valueOf(RANDOM.nextDouble(0.0, 10000.0)));
            return temp;
        };

        return Stream.generate(supplier).limit(capacity).collect(Collectors.toList());
    }
}
