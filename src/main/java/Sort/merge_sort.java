package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */

/**
 * 归并排序
 */
public class merge_sort {
    public static void merge_sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int pos = (left + right) / 2;
            merge_sort(arr, left, pos - 1, temp);
            merge_sort(arr, pos + 1, right, temp);
            merge(arr, left, pos, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int pos, int right, int[] temp) {
        int i = left, j = pos + 1;
        int m = pos, n = right;
        int k = 0;
        //while (i <= m && j <= right)
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        int[] temp = new int[arr.length];
        merge_sort(arr, 0, arr.length, temp);
    }
}
