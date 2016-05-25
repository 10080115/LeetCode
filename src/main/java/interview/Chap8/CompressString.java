package interview.Chap8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishiwei on 16/4/19.
 */

//如何转字符串

public class CompressString {
    public static void main(String[] args) {
        String str = "aaabbbccaaa";
        String str2 = "b";
        System.out.println(getArraySize(str));
        Set<Character> arr = new HashSet<Character>();
        arr.add('a');
        arr.add('e');
        arr.add('i');
        arr.add('o');
        arr.add('u');
        arr.contains(str.charAt(0));
    }

    public static String getArraySize(String str){
        int []arr = new int[256];
        String res = "";

        for (int i = 0; i <str.length() ; i++) {
            arr[str.charAt(i)-'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0) {
                char c = (char) (i + 'a');
                res+=c+String.valueOf(arr[i]);
            }
        }
        return res;
    }
}
