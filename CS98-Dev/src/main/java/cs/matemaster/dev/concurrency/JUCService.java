package cs.matemaster.dev.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cs.matemaster.web.common.constant.BizConstant;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author MateMaster
 * @since 2022/7/30
 */
public class JUCService {


    private static final ExecutorService CONCURRENCY = new ThreadPoolExecutor(
            BizConstant.CORE_POOL_SIZE,
            BizConstant.MAXIMUM_POOL_SIZE,
            BizConstant.MAXIMUM_POOL_SIZE,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("BizService-%d").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    @Test
    public void printThreadPoolExecutorProperty() {
        String capacity = Integer.toBinaryString((1 << 29) - 1);
        String running = Integer.toBinaryString(-1 << 29);
        String shutdown = Integer.toBinaryString(0 << 29);
        String stop = Integer.toBinaryString(1 << 29);
        String tidying = Integer.toBinaryString(2 << 29);
        String terminate = Integer.toBinaryString(3 << 29);

        System.out.println(StringUtils.leftPad(capacity, 32,"0"));
        System.out.println(StringUtils.leftPad(running, 32,"0"));
        System.out.println(StringUtils.leftPad(shutdown, 32,"0"));
        System.out.println(StringUtils.leftPad(stop, 32,"0"));
        System.out.println(StringUtils.leftPad(tidying, 32,"0"));
        System.out.println(StringUtils.leftPad(terminate, 32,"0"));
    }
}
