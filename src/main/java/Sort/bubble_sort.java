package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */

//冒泡排序

public class bubble_sort {
    // {3, 5, 7, 9, 2, 4, 8, 10, 1, 2};
    // 稳定的排序算法 时间复杂度O(n^2)
    public static void bubble_sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j])
                    constant.swap(arr, j + 1, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        bubble_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
