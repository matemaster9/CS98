package cs.matemaster.dev.coll;

import cs.matemaster.web.common.vo.SysUserVO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
public class CollDemo {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

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
}
