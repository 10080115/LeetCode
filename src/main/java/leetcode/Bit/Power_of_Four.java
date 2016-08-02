package leetcode.Bit;

/**
 * Created by lishiwei on 16/7/23.
 */
//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//Example:
//必须是2的次方 而且-1 是3的倍数

public class Power_of_Four {
    public boolean isPowerOfFour(int num) {
        return ((num - 1) & num) == 0 && (num - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Power_of_Four().isPowerOfFour(12));
    }
}
