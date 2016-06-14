package Thread;

/**
 * Created by lishiwei on 16/5/31.
 */
public class MyThread1 extends Thread {
    private int count = 5;

    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
    }
}
