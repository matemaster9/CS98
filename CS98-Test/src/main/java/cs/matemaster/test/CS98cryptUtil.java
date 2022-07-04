package cs.matemaster.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.var;
import org.assertj.core.util.Arrays;

import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/7/5
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CS98cryptUtil {

    public static long JAVAHash(Object... values) {
        if (Arrays.isNullOrEmpty(values)) {
            return 0L;
        }

        long result = 0L;

        for (var value : values) {
            result = 31 * result + (value == null ? 0 : value.hashCode());
        }
        return result;
    }
}
