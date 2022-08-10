package cs.matemaster.dev.coll;

import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.vo.SysUserVO;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
@Slf4j
public class CollDemo {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final List<ClubMember> ClubMembers = MockUtil.getClubMemberList(10);

    @Test
    public void packageType2BaseType() {
        Integer[] toArray = RANDOM.ints(100).boxed().toArray(Integer[]::new);
        int[] toInt = Arrays.stream(toArray).mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void list2Array() {
        String[] usernameArray = SysUserVO.generate(1000).stream().map(SysUserVO::getUsername).toArray(String[]::new);
        List<String> usernameList = Arrays.stream(usernameArray).collect(Collectors.toList());
    }

    @Test
    public void javaStream() {

    }

    @Test
    public void toBinaryArray() {
        String result = Arrays.toString(IntStream.iterate(1, x -> 2 * x).limit(10).toArray());
        log.info(result);
    }

}
