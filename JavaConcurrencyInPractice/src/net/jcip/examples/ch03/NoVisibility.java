package net.jcip.examples.ch03;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 * 执行的时候发生错误: java.lang.UnsupportedClassVersionError: 
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        //这个时候不能保证主线程写入ready和number的值对读线程是可见的
        number = 42;
        ready = true;
    }
}
