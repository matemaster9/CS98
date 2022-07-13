package cs.matemaster.web.common.webcore;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BizUtil {

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

    public static boolean isEmptyMap(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmptyMap(Map<?, ?> map) {
        return !isEmptyMap(map);
    }

    public static boolean isTrue(Boolean result) {
        return Boolean.TRUE.equals(result);
    }

    public static boolean isFalse(Boolean result) {
        return Boolean.FALSE.equals(result);
    }

    public static boolean isEmptyOrBlank(String str) {
        return StringUtils.isEmpty(str) || StringUtils.isBlank(str);
    }


    public static class Constants {
        public static final String BLANK = "";
    }
}
