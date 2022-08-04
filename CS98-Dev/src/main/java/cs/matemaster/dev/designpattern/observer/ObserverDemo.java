package cs.matemaster.dev.designpattern.observer;

import org.junit.Test;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
public class ObserverDemo {

    @Test
    public void demo() {
        new RMB(new ImportCompany(), new ExportCompany()).changeExRate(Boolean.TRUE);
        new RMB(new ImportCompany(), new ExportCompany()).changeExRate(Boolean.FALSE);
    }
}
