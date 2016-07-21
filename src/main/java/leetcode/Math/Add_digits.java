package leetcode.Math;

/**
 * Created by lishiwei on 16/7/20.
 */

/*
    Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
    Since 2 has only one digit, return it.
    18 -> 9
    27 -> 9
    12 -> 3
 */
public class Add_digits {
    public int addDigits(int num) {
        if (num <= 0)
            return num;
        else if (num % 9 != 0)
            return num % 9;
        else
            return 9;
    }
}
