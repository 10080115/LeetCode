package leetcode.Dynamic;

/**
 * Created by lishiwei on 16/7/23.
 */

//找到合理的递推公式
//思路 1 9 3 4 5 6 7 8
//           take   notake
// 每次的比较   1      0     =》 1
//             9       1     =>  9
//            1+3      9     =>  9
//            9+4      9     =>  13
public class House_Robber {
    public int rob(int[] nums) {
        int take = 0;
        int maxProfit = 0;
        int nonTake = 0;

        for (int num : nums) {
            take = nonTake + num;
            nonTake = maxProfit;
            maxProfit = Math.max(take, nonTake);
        }
        return maxProfit;
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        int[] res = new int[len];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
        }
        return res[len - 1];
    }
}
