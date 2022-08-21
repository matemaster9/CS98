package cs.matemaster.web;

import cs.matemaster.web.common.webcore.WebLogger;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MateMaster
 * @since 2022/8/21
 */
public class RegexTest {

    private static final String CHINESE_CODE = "[\\u4e00-\\u9fa5]";

    @Test
    public void test() {
        String content = "你好123";
        Pattern compile = Pattern.compile(CHINESE_CODE);
        Matcher matcher = compile.matcher(content);
        WebLogger.debug(matcher.find());
    }
}
