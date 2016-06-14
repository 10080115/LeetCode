package interview.BaiDu;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lishiwei on 16/5/29.
 */
/*
   拉姆刚开始学习英文单词，对单词排序很感兴趣。
   如果给拉姆一组单词，他能够迅速确定是否可以将这些单词排列在一个列表中，使得该列表中任何单词的首字母与前一单词的为字母相同。
   你能编写一个程序来帮助拉姆进行判断吗？

   输入包含多组测试数据。

   对于每组测试数据，第一行为一个正整数n，代表有n个单词。

   然后有n个字符串，代表n个单词。

   保证：

   2<=n<=200,每个单词长度大于1且小于等于10,且所有单词都是由小写字母组成。

  3
  abc
  cdefg
  ghijkl
  4
  abc
  cdef
  fghijk
  xyz

 */
public class test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count_word = sc.nextInt();
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < count_word; i++) {
                list.add(sc.next());
            }
            doThing(list);
        }
    }

    public static void doThing(ArrayList list_word) {
        int a1 = 0;
        int b = 0;
        for (int i = 0; i < list_word.size() - 1; i++) {
            String str1 = (String) list_word.get(i);
            String str2 = (String) list_word.get(i + 1);
            if (str1.charAt(str1.length()) == str2.charAt(0)) {

            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

}
