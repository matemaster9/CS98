package cs.matemaster.java.desingpattern.chainofresponsibility;

import cs.matemaster.web.common.webcore.WebLogger;

/**
 * @author MateMaster
 * @since 2022/8/11
 */
public class RoomManager extends AbstractHandler implements Handler {


    @Override
    public void handle(int days) {
        if (days > 3 && days <= 7) {
            WebLogger.info("RoomManager批准假期：" + days);
        }
    }
}
