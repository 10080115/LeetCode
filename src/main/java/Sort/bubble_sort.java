package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */

//冒泡排序

public class bubble_sort {
    // {3, 5, 7, 9, 2, 4, 8, 10, 1, 2};
    public static void bubble_sort(int[] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            int maxPos = i;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] > arr[maxPos])
                    maxPos = j;
            }
            swap(arr, maxPos, len - i);
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        bubble_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
