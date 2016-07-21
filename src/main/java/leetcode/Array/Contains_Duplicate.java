package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishiwei on 16/7/21.
 */
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0) return false;
        Set<Integer> hash = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        return hash.size() != nums.length;
    }
}
