package cs.matemaster.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bouncycastle.crypto.digests.SM3Digest;

/**
 * @author MateMaster
 * @since 2022/7/5
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashUtil {

    public static byte[] sm3Hash(byte[] message) {
        if (message == null || message.length == 0) {
            return new byte[0];
        }

        return null;
    }

    public static long objectsHash(Object... values) {
        if (values == null || values.length == 0) {
            return 0L;
        }

        long hash = 0L;

        for (Object element : values) {
            hash = 31L * hash + (element == null ? 0 : element.hashCode());
        }

        return hash;
    }
}
