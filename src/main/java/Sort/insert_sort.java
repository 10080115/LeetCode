package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */

//插入排序
//稳定排序 复杂度O(n^2)
public class insert_sort {
    void insert_sort(int[] arr) {
        int n = arr.length;
        int k = 0;
        for (int i = 1; i < n; i++) {
            //证明这时候要有元素整体向后移动
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                for (k = i - 1; k >= 0 && arr[k] > temp; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[k + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        new insert_sort().insert_sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
