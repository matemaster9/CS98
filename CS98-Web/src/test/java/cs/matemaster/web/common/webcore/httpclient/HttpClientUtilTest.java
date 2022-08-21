package cs.matemaster.web.common.webcore.httpclient;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public class HttpClientUtilTest {

    @Test
    public void test() {
        URL requestUrl = null;
        try {
            requestUrl = new URL("http://localhost:8080/sys/npe");
        } catch (MalformedURLException e) {

        }
        System.out.println(requestUrl.toString());
    }
}