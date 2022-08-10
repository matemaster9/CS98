package cs.matemaster.dev.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
@Slf4j
public class ExportCompany implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        Boolean exRate = (Boolean) arg;
        if (exRate) {
            log.error("汇率上升：出口公司亏钱");
        } else {
            log.info("汇率下降：出口公司赚钱");
        }
    }
}
