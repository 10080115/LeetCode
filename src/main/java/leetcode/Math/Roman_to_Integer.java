package leetcode.Math;

import java.util.*;

/**
 * Created by lishiwei on 16/7/21.
 */
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question
 */

public class Roman_to_Integer {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        Queue<Character> queue = new LinkedList<Character>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[arr.length - i - 1]);
        }
        //I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);

        int sum = hashmap.get(queue.peek());
        int a = hashmap.get(queue.peek());
        int b;
        queue.poll();
        while (!queue.isEmpty()) {
            b = hashmap.get(queue.peek());

            queue.poll();
            if (a <= b) {
                sum += b;
            } else {
                sum -= b;
            }
            a = b;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Roman_to_Integer().romanToInt("MCMXCVI"));
    }
}
