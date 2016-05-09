package net.jcip.examples.ch03;

/**
 * SafeListener
 * <p/>
 * Using a factory method to prevent the this reference from escaping during construction
 * 如果想在构造函数中注册监听器或启动线程, 
 * 你可以使用一个私有的构造函数和一个公共的工厂方法, 这样避免了不正确的构建
 * 为什么呢?和ThisEscape比较
 * @author Brian Goetz and Tim Peierls
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}

