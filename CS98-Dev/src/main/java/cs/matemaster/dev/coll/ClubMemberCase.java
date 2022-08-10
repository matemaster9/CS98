package cs.matemaster.dev.coll;

import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.webcore.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/8/5
 */
@Slf4j
public class ClubMemberCase {

    private static final List<ClubMember> ClubMembers = MockUtil.getClubMemberList(5000);

    @Test
    public void case1() {
        IntSummaryStatistics statistics = ClubMembers.stream().mapToInt(ClubMember::getAge).summaryStatistics();
        log.info("人数: " + statistics.getCount());
        log.info("平均年龄："  + statistics.getAverage());
        log.info("最大："  + statistics.getMax());
        log.info("最小："  + statistics.getMin());
    }


    @Test
    public void case2() {
        long sum = ClubMembers.stream()
                .filter(ClubMember::isSex)
                .mapToLong(ClubMember::getSerialNumber)
                .sum();
    }
}
