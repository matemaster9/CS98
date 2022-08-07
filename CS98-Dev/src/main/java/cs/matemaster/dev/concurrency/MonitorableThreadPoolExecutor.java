package cs.matemaster.dev.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author MateMaster
 * @since 2022/7/30
 */

public class MonitorableThreadPoolExecutor extends ThreadPoolExecutor {
    public MonitorableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public void beforeExecute(Thread t, Runnable r) {

    }

    public void afterExecute(Runnable r, Throwable t) {

    }

    public void terminated() {

    }
}
