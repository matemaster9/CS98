package cs.matemaster.dev.effectivejava.generalprogramming;

import cs.matemaster.dev.concurrency.JUCTimer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author MateMaster
 * @since 2022/8/7
 */
@Slf4j
public class Item61 {

    private static final JUCTimer JUC_TIMER = new JUCTimer();

    /**
     * 自动拆箱与包装类型的equals
     */
    @Test
    public void test() {
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : (x == y) ? 0 : 1;
        int compare = comparator.compare(new Integer(100), new Integer(100));
        log.info("奇怪结果：" + compare);

        Comparator<Integer> newComparator = (x, y) -> {
            int xBoxed = x;
            int yBoxed = y;
            return (xBoxed < yBoxed) ? -1 : (xBoxed == yBoxed) ? 0 : 1;
        };
        int newCompare = newComparator.compare(new Integer(100), new Integer(100));
        log.info("正确结果：" + newCompare);
    }

    /**
     * 包装类型带来的性能损耗
     */
    @Test
    public void demo() {
        JUC_TIMER.start();
        sumForPackaging();
        JUC_TIMER.stop();
        JUC_TIMER.start();
        sumForBase();
        JUC_TIMER.stop();
    }

    private Long sumForPackaging() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private long sumForBase() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
