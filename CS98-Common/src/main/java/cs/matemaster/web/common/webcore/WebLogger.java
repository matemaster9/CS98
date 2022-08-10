package cs.matemaster.web.common.webcore;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MateMaster
 * @since 2022/8/9
 */
@Slf4j
@NoArgsConstructor
public class WebLogger {

    public static void info(Object o) {
        String message = o.toString();
        log.info(message);
    }

    public static void debug(Object o) {
        String message = o.toString();
        log.info(message);
    }

    public static void error(Object o) {
        String message = o.toString();
        log.info(message);
    }
}
