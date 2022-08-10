package cs.matemaster.web.common.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MateMaster
 * @since 2022/8/5
 */
@Data
public class ClubMember {

    private long serialNumber;
    private int age;
    private int worth;
    private boolean sex;
    private String area;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public ClubMember() {
        serialNumber = RANDOM.nextLong(10_000_000, 99_999_999);
        age = RANDOM.nextInt(20,40);
        worth = RANDOM.nextInt(1_000_000);
        sex = RANDOM.nextBoolean();
        setArea(String.valueOf((char) RANDOM.nextInt(65,90)));
    }
}
