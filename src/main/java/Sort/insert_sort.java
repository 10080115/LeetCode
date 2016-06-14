package Sort;

/**
 * Created by lishiwei on 16/6/14.
 */

//插入排序
//稳定排序 复杂度O(n^2)
public class insert_sort {
    public static void insert_sort(int[] arr) {

        //总共进行的轮数
        for (int i = 1; i < arr.length; i++) {
            int start_pos = i;
            int target = arr[start_pos];
            while (start_pos > 0 && target < arr[start_pos - 1]) {
                arr[start_pos] = arr[start_pos - 1];
                start_pos--;
            }
            arr[start_pos] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        insert_sort(arr);
    }
}
