package Thread;

/**
 * Created by lishiwei on 16/5/31.
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
