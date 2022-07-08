package cs.matemaster.common.vo;

import lombok.Data;
import lombok.var;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/7/5
 */
@Data
public class SysUserVO {
    private String username;
    private String password;
    private String captcha;

    public SysUserVO() {
        setUsername(rdmUsername());
        setPassword(rdmPassword());
        setCaptcha(rdmCaptcha());
    }

    private static final String CMB = "CMB";
    private static final int DEFAULT_CAPACITY = 100_000;
    private static final ThreadLocalRandom currencyRdm = ThreadLocalRandom.current();
    private static final String ALPHABET_NUMBER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SINGLE_CAPACITY = 1;
    private static final int START_IDX = 0;

    public static List<SysUserVO> generate() {
        return generate(DEFAULT_CAPACITY);
    }

    public static List<SysUserVO> generate(int size) {
        return Stream.generate(SysUserVO::new).limit(size).collect(Collectors.toList());
    }

    private static String rdmUsername() {
        int random = currencyRdm.nextInt(99_999_999);
        return CMB + random;
    }

    private static String rdmPassword() {
        int len = 16;
        char[] pwd = new char[len];
        for (int i = 0; i < len; i++) {
            pwd[i] = ALPHABET_NUMBER.charAt(currencyRdm.nextInt(ALPHABET_NUMBER.length()));
        }
        return new String(pwd);
    }

    private static String rdmCaptcha() {
        var str = ALPHABET_NUMBER;
        var sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(currencyRdm.nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    public static SysUserVO rdmUser() {
        return generate(SINGLE_CAPACITY).get(START_IDX);
    }
}
