package leetcode;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishiwei on 16/4/26.
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if(s==null || s.length()==0)
            return s;
        Set<Character> arr = new HashSet<Character>();
        arr.add('a');
        arr.add('e');
        arr.add('i');
        arr.add('o');
        arr.add('u');
        arr.add('A');
        arr.add('E');
        arr.add('I');
        arr.add('O');
        arr.add('U');
        char[] ch=s.toCharArray();
        int len = ch.length-1;
        for(int i=0,j=len;i<=j;){
            if(arr.contains(ch[i]) && arr.contains(ch[j])){
                Character temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
                continue;
            }

            if(!arr.contains(ch[i]))
                i++;
            if(!arr.contains(ch[j]))
                j--;
        }
        String str = new String(ch);
        return str;
    }
public static void main(String[] args) throws ParseException, InterruptedException {

    // 可以用 StringBuilder 这个类，里面有一个接口replace，如下
    System.out.println(new ReverseVowelsofaString().reverseVowels(""));

}
}
