package interview;

/**
 * Created by lishiwei on 16/7/25.
 */
public class max {
    void max_string() {
        String str = "abcd12345ss54321";
        char[] arr = str.toCharArray();
        String max_s = "";
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                tmp += arr[i];
            } else {
                tmp = "";
            }

            if (tmp.length() > max_s.length()) {
                max_s = tmp;
            }
        }
        System.out.println(max_s);
    }

    public static void main(String[] args) {
        new max().max_string();
    }
}
