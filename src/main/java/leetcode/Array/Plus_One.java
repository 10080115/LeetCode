package leetcode.Array;

/**
 * Created by lishiwei on 16/7/24.
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            carry = digits[i] + carry > 9 ? 0 : 1;

            if (carry == 0) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        //证明要扩展了
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[0] = 1;

        return result;
    }
}
/*
int[] fun ={0,1,2,3,4,5,6};
System.arraycopy(fun,0,fun,3,3);
则结果为：{0,1,2,0,1,2,6};
代表从0开始起复制3个数 0、1、2
复制到fun数组 从3开始 的3个数
public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 */