package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/26.
 */

/*
设a≥1，b＞1为常数，f(n)为函数，T(n)=aT(n/b)+f(n)为非负数,令x=logba：
1.       f(n)=o(nx-e)，e＞0，那么T(n)=O(nx)。
2.       f(n)=O(nx)，那么T(n)=O(nx logn)。
*/

public class MergeSort {

    private static int arr[] = {2, 1, 3, 4, 5, 6, 7, 8, 10, 9, 11, 12, 13, 14, 15, 16};

    private static int aux[] = new int[16];

    private static void MergeSort(int lo, int hi) {
        if (lo == hi) return;
        int mid = (lo + hi) / 2;
        MergeSort(lo, mid);
        MergeSort(mid + 1, hi);
        Merge(lo, mid, hi);
    }

    private static void Merge(int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        //将数组打入辅助数组
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];

        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (aux[i] > aux[j]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }

    }

    public static void main(String[] args) {
        //定义整个数组进入
        MergeSort(0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
