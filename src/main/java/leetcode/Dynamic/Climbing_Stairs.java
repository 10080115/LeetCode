package leetcode.Dynamic;

/**
 * Created by lishiwei on 16/7/22.
 */
//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int a = 1;
        int b = 2;
        int res = a;
        while (n > 2) {
            res = a + b;
            a = b;
            b = res;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Climbing_Stairs().climbStairs(4));
    }
}
