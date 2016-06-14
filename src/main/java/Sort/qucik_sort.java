package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */
public class qucik_sort {
    // {3, 5, 7, 9, 2, 4, 8, 10, 1, 2};
    static void quick_sort(int[] arr, int l, int r) {
        //递归算法的跳出条件
        if (l < r) {
            int i = l;
            int j = r;
            int x = arr[l];
            while (i < j) {
                while (x < arr[j] && i < j)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (x > arr[i] && i < j)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quick_sort(arr, l, i - 1);
            quick_sort(arr, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int arr[] = constant.arr;
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(arr[0]);
    }
}
