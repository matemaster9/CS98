package cs.matemaster.dev.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
@Slf4j
public class ImportCompany implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Boolean exRate = (Boolean) arg;
        if (exRate) {
            log.info("汇率上升：进口公司赚钱" );
        } else {
            log.error("汇率下降：进口公司亏钱" );
        }
    }
}
