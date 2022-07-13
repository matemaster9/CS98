package cs.matemaster.web.common.webcore;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Hex;
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
    public static String SM3Hash(String msg) {
        if (BizUtil.isEmptyOrBlank(msg)) {
            return BizUtil.Constants.BLANK;
        } else {
            return bytes2HexStr(SM3Hash(msg.getBytes(StandardCharsets.UTF_8)));
        }
    }

    public static byte[] SM3Hash(byte[] msg) {
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
}
