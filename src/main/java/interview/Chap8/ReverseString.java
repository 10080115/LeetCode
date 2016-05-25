package interview.Chap8;

/**
 * Created by lishiwei on 16/4/19.
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse1("abc"));
        System.out.println(new ReverseString().reverse2("abc"));

    }

    public static String reverse1(String str){
        String reverse = "";

        for (int i = 0; i < str.length(); i++)
            reverse = str.charAt(i) + reverse;

        return reverse;
    }

    public static String reverse2(String str){

        if(str.length()<=1)
            return str;
        int len = str.length();

        String left = str.substring(0,len/2);
        String right = str.substring(len/2,str.length());
        return reverse2(right) + reverse2(left);
    }
}
