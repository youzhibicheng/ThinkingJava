package net.jcip.examples.ch03;

/**
 * ThisEscape
 * <p/>
 * Implicitly allowing the this reference to escape
 * 比较SafeListener
 * @author Brian Goetz and Tim Peierls
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
            	//因为执行了ThisEscape类的方法doSomething
            	//所以当发布EventListener的时候,相当于就发布了this引用
                doSomething(e);
            }
        });
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

