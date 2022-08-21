package cs.matemaster.web.common.webcore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author MateMaster
 * @since 2022/7/10
 */
@Slf4j
public class CryptoUtilTest {

    private static final String PLAIN = "plainText";

    @Test
    public void SM3HashTest() {
        log.info(CryptoUtil.sm3Hash(PLAIN));
    }
}
