package cs.matemaster.web.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BizUtil {

    public static <T> boolean isEmptyArray(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmptyArray(T[] array) {
        return !isEmptyArray(array);
    }

    public static boolean isEmptyColl(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmptyColl(Collection<?> coll) {
        return !isEmptyColl(coll);
    }

    public static boolean isTrue(Boolean result) {
        return Boolean.TRUE.equals(result);
    }

    public static boolean isFalse(Boolean result) {
        return Boolean.FALSE.equals(result);
    }
}
