package cs.matemaster.dev;

import cs.matemaster.dev.concurrency.JUCTimer;
import cs.matemaster.dev.concurrency.Timer;
import cs.matemaster.web.common.model.ComStaff;
import cs.matemaster.web.common.webcore.CryptoUtil;
import cs.matemaster.web.common.webcore.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/8/8
 */
@Slf4j
public class Murmurhash3Test {

    private static final Timer JUCTimer = new JUCTimer();

    @Test
    public void test() {
        JUCTimer.start();
        long result = Stream.generate(ComStaff::new).limit(5_000_000).mapToLong(comStaff ->
                CryptoUtil.murmurhash3(comStaff.getCode(),
                        comStaff.getSalary(),
                        comStaff.getSex(),
                        comStaff.getArea(),
                        comStaff.getStochasticNumber(),
                        comStaff.getArea()
                )
        ).distinct().count();
        log.info("murmurhash3：" + result);
        JUCTimer.stop();
    }

    @Test
    public void generateComStaff() {
        List<ComStaff> comStaffList = Stream.generate(ComStaff::new).limit(10000).collect(Collectors.toList());
        log.info(JsonUtil.serialize(comStaffList));
    }
}
