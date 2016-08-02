package leetcode.String;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by lishiwei on 16/7/22.
 */
//Reverse Vowels of a String
//关于将char 数组 转为 java String的方法
public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        List vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        s = s.replace(" ", "");

        boolean flag1 = true;
        boolean flag2 = true;
        char[] arr = s.toCharArray();


        for (int left = 0, right = arr.length - 1; left < right; ) {
            if (vowels.contains(arr[left]) && flag1)
                flag1 = false;
            if (vowels.contains(arr[right]) && flag2)
                flag2 = false;
            if (flag1)
                left++;
            if (flag2)
                right--;

            if (!flag1 && !flag2) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                flag1 = true;
                flag2 = true;
                left++;
                right--;
            }
        }

        return String.copyValueOf(arr);
    }

    public static void main(String[] args) {
        new Reverse_Vowels_of_a_String().reverseVowels("leetcode");
    }
}
