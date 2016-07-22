package leetcode.Math;

/**
 * Created by lishiwei on 16/7/22.
 */

//小于等于0的 直接排除掉
//2的次方 除了最高位是1以为 其他位都是0 所以减掉就好了
public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Power_of_Two().isPowerOfTwo(4));
    }
}
