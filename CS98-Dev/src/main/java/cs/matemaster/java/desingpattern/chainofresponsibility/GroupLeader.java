package cs.matemaster.java.desingpattern.chainofresponsibility;

import cs.matemaster.web.common.webcore.WebLogger;

/**
 * @author MateMaster
 * @since 2022/8/11
 */
public class GroupLeader implements Handler {


    @Override
    public void handle(int days) {
        if (days > 0 && days <= 3) {
            WebLogger.info("GroupLeader批准假期：" + days);
        }
    }
}
