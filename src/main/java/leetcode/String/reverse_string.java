package leetcode.String;

/**
 * Created by lishiwei on 16/7/12.
 */
public class reverse_string {
    //    Write a function that takes a string as input and returns the string reversed.
    //
    //    Example:
    //    Given s = "hello", return "olleh".
    //
    //    Subscribe to see which companies asked this question
    //    反转数组 利用头尾两个游标指针 进行运算
    public String reverse_string(String str) {
        if (str == null) return str;
        if (str.equals("")) return str;
        char arr[] = str.toCharArray();

        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new reverse_string().reverse_string("xiaoming"));
    }
}
