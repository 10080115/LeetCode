package Thread;

/**
 * Created by lishiwei on 16/5/31.
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        try {
            Thread.sleep(200000);
            myThread2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
