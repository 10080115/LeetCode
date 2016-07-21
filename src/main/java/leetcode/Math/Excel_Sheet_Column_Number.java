package leetcode.Math;

/**
 * Created by lishiwei on 16/7/21.
 */
/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
 */
public class Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Excel_Sheet_Column_Number().titleToNumber("AA"));
    }
}
