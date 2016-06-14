package Thread;

/**
 * Created by lishiwei on 16/5/31.
 */
class Thread2 implements Runnable {
    private int count = 15;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Thread3 extends Thread {
    private int count = 15;

    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class Main {

    public static void main(String[] args) {

        Thread3 my = new Thread3();
        new Thread(my, "C").start();//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
        new Thread(my, "D").start();
    }

}
