package interview.Chap8;

import java.util.Arrays;

/**
 * Created by lishiwei on 16/4/19.
 */
public class ChangeString {
    public static void main(String[] args) {
        System.out.println(new ChangeString().judgeForEqual1("xiaoming","xiaominx"));
        System.out.println(new ChangeString().judgeForEqual2("xiaoming","xiaominx"));

    }

    public static String sort(String str){
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    public static boolean judgeForEqual2(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        return sort(str1).equals(sort(str2));

    }
    public static boolean judgeForEqual1(String str1,String str2){
        int []arr = new int[256];
        String x = new String();

        if(str1.length()!=str2.length())
            return false;

        for (int i = 0; i <str1.length() ; i++)
            arr[str1.charAt(i)-'a']++;

        for (int i = 0; i < str1.length(); i++) {
            arr[str2.charAt(i)-'a']--;
            if( arr[str2.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
