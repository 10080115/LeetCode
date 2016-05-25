package leetcode;

/**
 * Created by lishiwei on 16/4/26.
 */
//判断回文函数
public class isPalindrome {
    public boolean isPalindrome(int x) {
        String y = String.valueOf(x);
        String res = new String();
        for (int i = 0; i <y.length() ; i++) {
            res = y.charAt(i)+res;
        }
        return res.equals(y);
    }
}
