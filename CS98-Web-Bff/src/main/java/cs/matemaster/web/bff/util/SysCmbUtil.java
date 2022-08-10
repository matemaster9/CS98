package cs.matemaster.web.bff.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SysCmbUtil {

    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    public static LocalDateTime convertIgnoreErr(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN);
        try {
            return LocalDateTime.parse(datetime, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
