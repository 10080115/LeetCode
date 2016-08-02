//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
//
///**
// * Created by lishiwei on 16/7/28.
// */
class Base {
    static {
        test();
    }

    static void test() {
        System.out.println("HelloWorld");
    }
}

class Sub extends Base {
    public int f() {
        System.out.println("Sub");
        return 1;
    }
}

public class TEST {
    public static void main(String[] args) {

    }
}
