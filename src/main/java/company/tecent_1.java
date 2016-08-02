package company;

/**
 * Created by lishiwei on 16/8/2.
 */
/*
给定一个字符串s，你可以从中删除一些字符，
使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。
求一个字符串和他的反串的公共子川的长度
 */
//最长公共子串是连续的
//最长公共子序列是不要求连续的

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class tecent_1 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String str2 = new StringBuffer(str).reverse().toString();
            char[] arr = str.toCharArray();
            int len = arr.length;
            //定义一个二维数组
            int[][] dp = new int[len + 1][len + 1];
            //赋值给数组的元素

            for (int i = 0; i < len; i++) {
                dp[0][i] = 0;
            }

            for (int i = 0; i < len; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= len; j++) {
                    if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(len - dp[len][len]);
        }
    }
}
