package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */
public class constant {
    public static final int[] arr = {3, 5, 7, 9, 2, 4, 8, 10, 1, 2};

    static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    static void for_each(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
