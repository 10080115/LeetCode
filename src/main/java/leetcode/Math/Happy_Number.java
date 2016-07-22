package leetcode.Math;

import apple.laf.JRSUIConstants;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by lishiwei on 16/7/22.
 */
//利用一个set不断地存数就行了
public class Happy_Number {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        int sum = n;
        while (sum < Integer.MAX_VALUE) {
            sum = get_square(sum);
            if (set.contains(sum))
                return false;
            if (sum == 1)
                return true;
            set.add(sum);
        }
        return false;
    }

    public int get_square(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }

}
