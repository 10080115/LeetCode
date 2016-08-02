package JavaReview;

/**
 * Created by lishiwei on 16/7/31.
 */
public class min_dist {
    public static int min_dist(int[] arr, int n1, int n2) {
        int n1_index = -1;
        int n2_index = -1;
        int min_dist = Integer.MIN_VALUE + 1;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == n1) {
                n1_index = i;
                if (n2_index > 0) {
                    System.out.println(n1_index + " " + n2_index);
                    min_dist = min(Math.abs(min_dist), Math.abs(n2_index - n1_index));
                }
            }
            if (arr[i] == n2) {
                n2_index = i;
                if (n1_index > 0) {
                    System.out.println(n1_index + " " + n2_index);
                    min_dist = min(Math.abs(min_dist), Math.abs(n2_index - n1_index));
                }
            }
        }
        return min_dist;
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        System.out.println(min_dist(arr, 4, 6));
    }
}
