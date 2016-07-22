package leetcode.Array;

import java.util.Arrays;

/**
 * Created by lishiwei on 16/7/21.
 */

//判断数组里面是否有重复的元素 利用数组先进行排序 之后遍历一遍 看是否有相同的元素

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        //进行了排序
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return true;
        }
        return false;
    }
}
