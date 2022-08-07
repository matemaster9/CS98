package cs.matemaster.web.common.dto;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
@Data
public class ComStaffDTO {

    private String number;

    public ComStaffDTO() {
        setNumber(rdmNumber());
    }

    private static final String COM = "CMB";
    private static final int DEFAULT_CAPACITY = 10_000;
    private static final ThreadLocalRandom currencyRdm = ThreadLocalRandom.current();

    public static List<ComStaffDTO> generate() {
        return generate(DEFAULT_CAPACITY);
    }

    public static List<ComStaffDTO> generate(int size) {
        return Stream.generate(ComStaffDTO::new).limit(size).collect(Collectors.toList());
    }

    private static String rdmNumber() {
        return COM + currencyRdm.nextInt(10_000_000,99_999_999);
    }
}
