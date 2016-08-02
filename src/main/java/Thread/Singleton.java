package Thread;

/**
 * Created by lishiwei on 16/7/29.
 */
public class Singleton {
    private Singleton() {
        System.out.println(2);
    }

    private static Singleton single = null;

    //静态工厂方法
    public static Singleton getInstance() {
        System.out.println(1);
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
    public static void main(String[] args) {

    }
}
