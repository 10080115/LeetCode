package JavaReview;

import Sort.constant;

/**
 * Created by lishiwei on 16/7/31.
 */
//利用快速排序减枝
public class get_kth {
    private static int quick_sort(int[] arr, int left, int right, int kth) {
        if (left < right) {
            int i = left, j = right;
            int temp = arr[i];
            while (i < j) {
                while (i < j && arr[j] > temp)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < temp)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = temp;
            if (i + 1 == kth)
                return temp;
            if (i + 1 < kth)
                return quick_sort(arr, i + 1, right, kth);
            else
                return quick_sort(arr, left, i - 1, kth);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        System.out.println(quick_sort(arr, 0, arr.length - 1, 3));
    }
}
