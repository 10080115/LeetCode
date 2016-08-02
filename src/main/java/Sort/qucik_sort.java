package Sort;

import com.sun.tools.javac.code.Attribute;

/**
 * Created by lishiwei on 16/6/14.
 */
public class qucik_sort {
    // 最好的情况下：因为每次都将序列分为两个部分(一般二分都复杂度都和logN相关)，故为 O(N*logN)
    // 最坏的情况下：基本有序时，退化为冒泡排序，几乎要比较N*N次，故为O(N*N)
    // 不稳定算法
    void quick_sort(int[] arr, int l, int r) {
        //递归算法的跳出条件
        if (l < r) {
            int i = l, j = r, x = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= x)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < x)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quick_sort(arr, l, i - 1);
            quick_sort(arr, i + 1, r);

        }
    }

    //最好的情况是数组已经有序了 遍历一遍即可
    //最坏的情况是倒叙 每次都要向后移动O(n^2)
    //平均复杂度是O(n^2) 是一个稳定的算法
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

    void shell_sort(int[] arr) {

    }

    //改进版 如果又一次没有交换元素的话 就可以退出了
    void bubble_sort(int[] arr) {
        int len = arr.length;
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    flag = true;
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //最好的情况交换0次 最坏的话需要交换n次 遍历了O(N*N)
    //不稳定排序 因为要跨域交换
    void select_sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            if (i != min)
                swap(arr, i, min);
        }
    }

    static void print_array(int[] array) {
        for (int num : array)
            System.out.print(num + " ");
    }


    //构建升序 大顶堆
    void heap_sort(int[] array) {
        if (array == null || array.length <= 1) return;
        //构建二叉树
        build_MaxHeap(array, array.length - 1);
        int last_index = array.length - 1;

        while (last_index > -1) {
            swap(array, 0, last_index);
            build_MaxHeap(array, --last_index);
        }
//        for (int i = array.length - 1; i >= 0; --i) {
//            //最后一个元素和第一元素进行交换
//            swap(array, i, 0);
//            //然后将剩下的无序元素继续调整为大顶堆
//            build_MaxHeap(array, i - 1);
//        }
    }

    void build_MaxHeap(int[] array, int largest_index) {
        int last_index = array.length / 2;
        for (int i = last_index; i >= 0; i--) {
            maxHeap(array, i, largest_index);
        }
    }

    //代表起始点 代表终点
    void maxHeap(int[] array, int index, int largest_index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxLR = -1;

        //无孩子
        if (left > largest_index)
            return;

        if (left == largest_index)
            maxLR = left;

        if (right <= largest_index)
            maxLR = array[left] > array[right] ? left : right;

        if (array[index] > array[maxLR]) {
            return;
        } else {
            swap(array, index, maxLR);
            // 递归进行堆调整
            maxHeap(array, maxLR, largest_index);
        }
    }

    public static void main(String[] args) {
        int[] arr2 = {10, 60, 30, 40, 8, 12, 70, 9, 8, 4, 2, 0, 5, 1, 3};
        new qucik_sort().heap_sort(arr2);
        print_array(arr2);
    }
}
