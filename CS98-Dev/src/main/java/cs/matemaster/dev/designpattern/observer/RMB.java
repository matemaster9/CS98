package cs.matemaster.dev.designpattern.observer;

import java.util.Observable;

/**
 * @author MateMaster
 * @since 2022/8/4
 */
public class RMB extends Observable {

    public RMB(ImportCompany importCompany, ExportCompany exportCompany) {
        addObserver(importCompany);
        addObserver(exportCompany);
    }

    public void changeExRate(Boolean upOrDown) {
        setChanged();
        notifyObservers(upOrDown);
    }
}
