package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/25.
 */
public class FullArray {
    static int n = 0;

    public static void perm(int[] list, int k, int m) {
        int i;
        if (k == m) {
            for (i = 0; i <= m; i++)
                System.out.print(list[i]);
            System.out.println();
            n++;
        } else {
            for (i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, k, i);
            }
        }
    }

    //交换函数
    public static void swap(int[] list, int k, int i) {
        int temp = list[i];
        list[i] = list[k];
        list[k] = temp;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        perm(list, 0, 4);
        System.out.println(n);
    }
}
