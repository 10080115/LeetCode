package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/27.
 */
public class SortUtil {
    public static boolean less(Comparable v, Comparable t) {
        return v.compareTo(t) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
