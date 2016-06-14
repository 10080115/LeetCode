package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */
public class selected_sort {

    public static void selected_sort(int[] arr) {
        //表示的是趟数
        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = 1; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[max])
                    max = j;
            }
            constant.swap(arr, max, arr.length - 1 - i);
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        selected_sort(arr);
        System.out.println(arr[0]);
    }
}
