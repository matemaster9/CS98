package cs.matemaster.java.desingpattern.chainofresponsibility;

import cs.matemaster.web.common.webcore.WebLogger;

/**
 * @author MateMaster
 * @since 2022/8/11
 */
public class Boss implements Handler {

    @Override
    public void handle(int days) {
        if (days > 7 && days <= 15) {
            WebLogger.info("Boss批准假期：" + days);
        } else if (days > 15) {
            WebLogger.error("违反公司规定！");
        }
    }
}
