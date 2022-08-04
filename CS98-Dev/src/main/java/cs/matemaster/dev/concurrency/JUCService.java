package cs.matemaster.dev.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cs.matemaster.web.common.constant.BizConstant;
import cs.matemaster.web.common.dto.ComStaffDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author MateMaster
 * @since 2022/7/30
 */
@Slf4j
public class JUCService {


    private static final ExecutorService CONCURRENCY = new ThreadPoolExecutor(
            BizConstant.CORE_POOL_SIZE,
            BizConstant.MAXIMUM_POOL_SIZE,
            BizConstant.MAXIMUM_POOL_SIZE,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("Concurrency-%d").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    private static final Timer JUCTimer = new JUCTimer();

    @Test
    public void printThreadPoolExecutorProperty() {
        String capacity = Integer.toBinaryString((1 << 29) - 1);
        String running = Integer.toBinaryString(-1 << 29);
        String shutdown = Integer.toBinaryString(0 << 29);
        String stop = Integer.toBinaryString(1 << 29);
        String tidying = Integer.toBinaryString(2 << 29);
        String terminate = Integer.toBinaryString(3 << 29);

        log.info(StringUtils.leftPad(capacity, 32, "0"));
        log.info(StringUtils.leftPad(running, 32, "0"));
        log.info(StringUtils.leftPad(shutdown, 32, "0"));
        log.info(StringUtils.leftPad(stop, 32, "0"));
        log.info(StringUtils.leftPad(tidying, 32, "0"));
        log.info(StringUtils.leftPad(terminate, 32, "0"));
    }

    @Test
    public void synchronousMethod() throws InterruptedException {
        JUCTimer.start();
        log.info(String.valueOf(concurrency().size()));
        JUCTimer.stop();
    }

    @Test
    public void concurrentService() throws InterruptedException {
        JUCTimer.start();
        log.info(String.valueOf(getComStaffListConcurrently().size()));
        JUCTimer.stop();
    }

    private List<ComStaffDTO> concurrency() throws InterruptedException {
        int count = 1000;
        CountDownLatch latch = new CountDownLatch(count);
        List<ComStaffDTO> comStaffList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < count; i++) {
            CONCURRENCY.execute(() -> {
                log.debug(Thread.currentThread().getName());
                comStaffList.addAll(ComStaffDTO.generate(10000));
                latch.countDown();
            });
        }
        latch.await();
        return comStaffList;
    }

    private List<ComStaffDTO> sequential() {
        return ComStaffDTO.generate(100_000_000);
    }

    private List<ComStaffDTO> getComStaffListConcurrently() throws InterruptedException {
        int count = 1000;
        CountDownLatch latch = new CountDownLatch(count);
        List<ComStaffDTO> comStaffList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < count; i++) {
            CONCURRENCY.submit(new GenerateComStaffTask(comStaffList, latch));
        }
        latch.await();

        return comStaffList;
    }

    @Getter
    @RequiredArgsConstructor
    static class GenerateComStaffTask implements Callable<Void> {

        private final List<ComStaffDTO> result;
        private final CountDownLatch latch;

        @Override
        public Void call() {
            log.debug(Thread.currentThread().getName());
            result.addAll(ComStaffDTO.generate(10000));
            latch.countDown();
            return null;
        }
    }
}
