package interview.Chap8;

/**
 * Created by lishiwei on 16/4/19.
 */

//先算出扩充后的数组长度 之后按位补全即可

public class FillingBlank {

    public static void main(String[] args) {
        String str = "RemoveLinkedListElements b ";
        char[] arr = str.toCharArray();
        System.out.println(FillBlank2(arr));
    }

    public static String FillBlank2(char[] arr){
        int count = 0;
        int oldLength = arr.length;
        for (int i = 0; i < oldLength; i++) {
            if(arr[i]==' ')
                count++;
        }
        char arr2[] = new char[oldLength+count*2];
        int newLength = arr2.length;

        for (int i = oldLength-1; i >=0 ; i--) {
            if(arr[i]==' '){
                System.out.println("Coming");
                arr2[newLength-1] = '0';
                arr2[newLength-2] = '2';
                arr2[newLength-3] = '%';
                newLength-=3;
            }else{
                arr2[--newLength] = arr[i];
            }
        }
        for (int i = 0; i <arr2.length ; i++) {
            System.out.println(arr2[i]);
        }
        return arr2.toString();
    }
}
