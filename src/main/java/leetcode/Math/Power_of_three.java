package leetcode.Math;

/**
 * Created by lishiwei on 16/7/22.
 */
public class Power_of_three {
    //-2147483648——2147483647 10位数字
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        int a = 3 >> 1;
        System.out.println(a);
    }
}
