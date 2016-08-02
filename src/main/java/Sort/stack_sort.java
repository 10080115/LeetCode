package Sort;

import com.sun.tools.javac.code.Attribute;

import static Sort.constant.swap;

/**
 * Created by lishiwei on 16/6/27.
 */
public class stack_sort {
    //插入总是将新数据放在数组最后
    //删除元素总是在A[0]处 然后用最后一个元素弥空缺


    //最小堆 新加入的结点放在
    public static void stack_sort(int[] arr) {
        int len = arr.length;
        //先构建
        for (int start = len / 2 - 1; start >= 0; start--)
            build_stack(arr, start, len - 1);
        for (int i = len - 1; i >= 0; ) {
            swap(arr, 0, i);
            build_stack(arr, 0, --i);
        }
    }

    public static void build_stack(int[] array, int start, int end) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int minLR = -1;

        if (left > end)
            return;
        if (left == end)
            minLR = left;
        if (right <= end)
            minLR = array[left] > array[right] ? left : right;

        if (array[start] > array[minLR]) {
            return;
        } else {
            swap(array, start, minLR);
            // 递归进行堆调整
            build_stack(array, minLR, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = constant.arr;
        for (int num : arr)
            System.out.print(num + " ");
        stack_sort(arr);
        System.out.println();
        for (int num : arr)
            System.out.print(num + " ");
    }
}
