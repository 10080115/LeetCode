package JavaReview;

import Algorithm.Recursion.IntegerDiv;

/**
 * Created by lishiwei on 16/7/31.
 */
public class max_diff_couple {
    private static int max(int m, int n) {
        return m > n ? m : n;
    }

    //最终目的是找到最大的 被减数 和 最小的减数L
    private static int getMax(int[] a) {
        if (a == null) return Integer.MIN_VALUE;
        int len = a.length;
        if (len <= 1)
            return Integer.MIN_VALUE;
        int[] par = new int[a.length];
        int[] diff = new int[a.length];
        par[0] = a[0];
        diff[0] = 0;
        for (int i = 1; i < len; i++) {
            diff[i] = max(diff[i - 1], par[i - 1] - a[i]);
            par[i] = max(par[i - 1], a[i]);
        }
        return diff[len - 1];
    }


    public static void main(String[] args) {
        int[] a = {1, 4, 17, 3, 2, 9};
        System.out.println(getMax(a));
    }
}
