package cs.matemaster.web.common.webcore;

import cs.matemaster.web.common.constant.BizConstant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.var;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.MurmurHash3;
import org.bouncycastle.crypto.digests.SM3Digest;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @author MateMaster
 * @since 2022/7/10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CryptoUtil {

    /**
     * SM3 摘要算法
     *
     * @param msg
     * @return
     */
    public static String sm3Hash(String msg) {
        if (BizUtil.isEmptyOrBlank(msg)) {
            return BizConstant.EMPTY_STR;
        } else {
            return bytes2HexStr(sm3Hash(msg.getBytes(StandardCharsets.UTF_8)));
        }
    }

    public static byte[] sm3Hash(byte[] msg) {
        if (msg == null || msg.length == 0) {
            return new byte[0];
        } else {
            byte[] result = new byte[32];
            SM3Digest sm3Digest = new SM3Digest();
            sm3Digest.update(msg, 0, msg.length);
            sm3Digest.doFinal(result, 0);
            sm3Digest.reset();
            return result;
        }
    }

    public static String bytes2HexStr(byte[] bytes) {
        return Hex.encodeHexString(bytes).toUpperCase(Locale.ROOT);
    }

    /**
     * Murmurhash3
     *
     * @param args
     * @return
     */
    public static long murmurhash3(Object... args) {
        if (args == null || args.length == 0) {
            return 0L;
        }

        var builder = new StringBuilder(args.length);
        for (Object arg : args) {
            builder.append(arg.toString());
        }

        return MurmurHash3.hash64(builder.toString().getBytes(StandardCharsets.UTF_8), 0, builder.length());
    }

    /**
     * Objects.hash(args) long 版本
     *
     * @param args
     * @return
     */
    public static long standardHash(Object... args) {
        if (args == null)
            return 0;

        long result = 1L;

        for (Object element : args)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
    }
}
