package leetcode;

/**
 * Created by lishiwei on 16/4/25.
 */
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//定义一个255的数组
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s==null && t==null)
            return true;

        if(s==null)
            return false;

        if(t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        int[] arr =new int[255];

        for (int i = 0; i <s.length(); i++) {
            arr[s.charAt(i)-'a']++;

        }

        for(int i =0;i<t.length();i++) {
            if (--arr[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("xiaoming","xiaoning"));
    }
}
