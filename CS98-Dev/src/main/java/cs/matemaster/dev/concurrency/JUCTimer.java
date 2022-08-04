package cs.matemaster.dev.concurrency;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
@Setter
@Getter
@Slf4j
public class JUCTimer implements Timer {

    private long now;

    @Override
    public void start() {
        setNow(System.currentTimeMillis());
    }

    @Override
    public void stop() {
        log.info(String.valueOf(System.currentTimeMillis() - getNow()));
    }
}
