package Thread;

/**
 * Created by lishiwei on 16/5/31.
 */

/**
 *
 */
class ThreadTest implements Runnable {
    private int tickets = 100;

    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() +
                        " is saling ticket " + tickets--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        new Thread(t, "a").start();
        new Thread(t, "b").start();
        new Thread(t, "c").start();
        new Thread(t, "d").start();
    }
}