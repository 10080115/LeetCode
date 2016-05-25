package leetcode;

/**
 * Created by lishiwei on 16/4/25.
 */
//每个字符出现两次只有一个字符出现1次 找到这个字符
// 1 & 1 = 1
// 1 ^ 1 = 0  0 ^ 0 = 0 1 ^ 0 = 1
// 1 | 0 = 1 //代表的是有1为1
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<=nums.length-1;i++){
            res ^= nums[i];
        }
        return res;
    }
}
