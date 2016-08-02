package JavaReview;

/**
 * Created by lishiwei on 16/7/31.
 */
public class reverse_string {
    //先是对整个字符串进行反转 再对每个单词进行反转
    public static void swap(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String str = "how are you";
        //拿到了字符数组 两个index 进行交换
        char[] arr = str.toCharArray();
        swap(arr, 0, arr.length - 1);

        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 32) {
                swap(arr, begin, i - 1);
                begin = i + 1;
            }
        }
        swap(arr, begin, arr.length - 1);
        str = new String(arr);
        System.out.println(str);
    }
}
