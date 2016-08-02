package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/7/27.
 */
/*
   [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
   ]
 */
    //list 的起始位置是0 结束位置是list.size-1
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> pre_list = new ArrayList<Integer>();
        if (numRows == 0)
            return res;

        pre_list.add(1);
        res.add(pre_list);
        List<Integer> cur_list;
        int level = 1;
        while (level < numRows) {
            cur_list = new ArrayList<Integer>();
            for (int i = 0; i < pre_list.size() - 1; i++) {
                cur_list.add(pre_list.get(i) + pre_list.get(i + 1));
            }
            cur_list.add(0, 1);
            cur_list.add(cur_list.size(), 1);
            res.add(cur_list);
            pre_list = cur_list;
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pascals_Triangle().generate(3).get(0));
    }
}
