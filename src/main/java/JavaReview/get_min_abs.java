package JavaReview;

/**
 * Created by lishiwei on 16/7/31.
 */
//8.5.12
public class get_min_abs {
    private static int get_min_abs(int[] arr) {
        if (arr == null || arr.length == 0)
            return Integer.MIN_VALUE;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (true) {
            //记录中间位置
            mid = left + (right - left) / 2;
            if (arr[mid] == 0)
                return 0;
            else if (arr[mid] > 0) {
                if (arr[mid - 1] > 0)
                    right = mid - 1;
                else if (arr[mid - 1] == 0)
                    return 0;
                else
                    break;
            } else {
                if (arr[mid + 1] < 0)
                    left = mid + 1;
                else if (arr[mid + 1] == 0)
                    return 0;
                else
                    break;
            }
        }
        if (arr[mid] > 0)
            return min_abs(arr[mid - 1], arr[mid]);
        else
            return min_abs(arr[mid], arr[mid + 1]);
    }

    private static int min_abs(int a, int b) {
        return Math.abs(a) > Math.abs(b) ? b : a;
    }

    public static void main(String[] args) {
        int[] arr = {-10, 5, -2, 7, 15, 50};
        int value = get_min_abs(arr);
        System.out.println(value);
    }
}
