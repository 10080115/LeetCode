package Algorithm.Recursion;

import java.util.Random;


/**
 * Created by lishiwei on 16/5/27.
 */

/**
 * 线性时间选择
 */

public class randomizedSelectTest {

    private static int randomizedPartition(int[] a, int p, int r) {
        int i = random(p, r);
        swap(a, i, p);//交换枢纽元素到区间左端
        return partition(a, p, r);
    }

    /**
     * 线性选择指定数组中第k小的元素
     *
     * @param a 指定数组
     * @param p 区间左端
     * @param r 区间右端
     * @param k 数组的大小位置
     * @return 返回指定数组中第k小的元素
     */
    @SuppressWarnings("unused")
    private static int randomizedSelect(int[] a, int p, int r, int k) {
        if (p == r) return a[p];
        int i = randomizedPartition(a, p, r);
        int j = i - p + 1;//左端元素个数
        //第k小的元素在左端
        if (k <= j) return randomizedSelect(a, p, i, k);
        else//第k小的元素在右端，并且左端已经有j个比它小的元素
            //所以只要找右端中的第k-j小的元素就可以
            return randomizedSelect(a, i + 1, r, k - j);
    }

    private static int random(int i, int j) {
        Random r = new Random();
        return r.nextInt(j - i) + i;
    }

    private static int partition(int[] a, int p, int r) {
        int i = p, j = r + 1;
        int x = a[p];
        while (true) {
            while (a[++i] < x && i < r) ;
            while (a[--j] > x) ;
            if (i >= j) break;
            swap(a, i, j);
        }
        a[p] = a[j];
        a[j] = x;
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 4, 5, 6};
        System.out.println(randomizedSelect(arr, 0, arr.length - 1, 2));
    }
}