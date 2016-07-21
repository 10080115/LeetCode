package leetcode.Bit;

/**
 * Created by lishiwei on 16/7/20.
 */

//    Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//    Example:
//    Given a = 1 and b = 2, return 3.

public class Sum_of_Two_Integers {
    public int Sum_of_Two_Integers(int a, int b) {
        int sum, carray;
        do {
            sum = a ^ b;
            //因为进位是向前边进位的 所以要左移一位
            carray = (a & b) << 1;
            a = sum;
            b = carray;
        } while (b != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Sum_of_Two_Integers().Sum_of_Two_Integers(3, 5));
    }
}
