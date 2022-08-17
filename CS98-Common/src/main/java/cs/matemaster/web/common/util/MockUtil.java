package cs.matemaster.web.common.util;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.model.ComStaff;

import java.util.ArrayList;
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
    private static final String[] AREA_ARRAY = {"北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省", "吉林省", "黑龙江省", "上海市", "江苏省", "浙江省", "安徽省",
            "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西壮族自治区", "海南省", "四川省", "贵州省", "云南省", "重庆市", "西藏自治区", "陕西省", "甘肃省",
            "青海省", "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区", "台湾省"};

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

    public static List<String> getAreaList(int capacity) {
        List<String> areaList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            areaList.add(AREA_ARRAY[RANDOM.nextInt(AREA_ARRAY.length)]);
        }
        return areaList;
    }
}
