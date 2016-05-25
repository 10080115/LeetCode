package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/4/26.
 */
public class PascalsTriangleII {
    public static List<Integer> generate(int numRows) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 1; i <= numRows; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = ret.get(j - 1) + ret.get(j);
                ret.set(j, tmp);
            }
            ret.add(1);
        }

        return ret;
    }
}