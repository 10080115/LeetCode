package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/26.
 */
public class BinarySearch {
    //二分查找算法
    private static int binarySearch(int[] arr, int x, int n) {
        //定义查找的左右边界
        int left = 0, right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == x) return (middle + 1);
            else if (arr[middle] > x) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 9, 10, 25, 33};
        System.out.println(binarySearch(arr, 1, arr.length));
    }
}
