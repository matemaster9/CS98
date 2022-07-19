package cs.matemaster.web.common.dto;

import cs.matemaster.web.common.vo.SysUserVO;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Data
public class SysUserDTO {
    private String username;
    private String password;

    public SysUserDTO() {
        setUsername(rdmUsername());
        setPassword(rdmPassword());
    }

    private static final String CMB = "CMB";
    private static final int DEFAULT_CAPACITY = 10_000;
    private static final ThreadLocalRandom currencyRdm = ThreadLocalRandom.current();
    private static final String ALPHABET_NUMBER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static List<SysUserDTO> generate() {
        return generate(DEFAULT_CAPACITY);
    }

    public static List<SysUserDTO> generate(int size) {
        return Stream.generate(SysUserDTO::new).limit(size).collect(Collectors.toList());
    }

    private static String rdmUsername() {
        return CMB + currencyRdm.nextInt(99_999_999);
    }

    private static String rdmPassword() {
        int len = 16;
        char[] pwd = new char[len];
        for (int i = 0; i < len; i++) {
            pwd[i] = ALPHABET_NUMBER.charAt(currencyRdm.nextInt(ALPHABET_NUMBER.length()));
        }
        return new String(pwd);
    }
}
