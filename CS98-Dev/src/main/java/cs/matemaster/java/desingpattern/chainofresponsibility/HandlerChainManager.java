package cs.matemaster.java.desingpattern.chainofresponsibility;

import cs.matemaster.java.desingpattern.builder.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/11
 */
public class HandlerChainManager {

    private List<Handler> handlers;

    private HandlerChainManager(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public static HandlerChainBuilder builder() {
        return new HandlerChainBuilder();
    }

    public void onHandle(int arg) {
        handlers.forEach(handler -> handler.handle(arg));
    }

    public static class HandlerChainBuilder implements Builder<HandlerChainManager> {

        private List<Handler> handlers;

        public HandlerChainBuilder() {
            this.handlers = new ArrayList<>();
        }

        public HandlerChainBuilder addHandler(Handler handler) {
            handlers.add(handler);
            return this;
        }

        @Override
        public HandlerChainManager build() {
            return new HandlerChainManager(this.handlers);
        }
    }
}
