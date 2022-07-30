package cs.matemaster.dev.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cs.matemaster.web.common.constant.BizConstant;

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
            new ThreadFactoryBuilder().setNameFormat("concurrentService-").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );
}
