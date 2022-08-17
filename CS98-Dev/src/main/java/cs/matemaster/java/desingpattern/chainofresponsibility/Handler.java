package cs.matemaster.java.desingpattern.chainofresponsibility;

/**
 * @author MateMaster
 * @since 2022/8/11
 */
public interface Handler<T> {

    void handle(T arg);

    void handle(int days);
}
