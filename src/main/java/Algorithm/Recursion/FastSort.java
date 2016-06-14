package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/27.
 */
public class FastSort {

    private static int arr[] = {2, 1, 3, 4, 5, 6, 7, 8, 10, 9, 11, 12, 13, 14, 15, 16};

    //必须每次都要判断 i 和 j 的关系
    public static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[i];
            while (i < j) {
                while (i < j && x < arr[j])
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && x > arr[i])
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        quick_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
