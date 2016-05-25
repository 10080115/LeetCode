package leetcode;

/**
 * Created by lishiwei on 16/4/17.
 */

public class MissingNumber {
    //利用等差数列的求和公式
    public static int missingNumber(int[] nums) {

        int last = nums.length+1;
        int count = nums.length;
        int sum = (last)*count/2;

        for (int i = 0; i < nums.length; i++)
            sum = sum - nums[i];
        return sum;
    }

    public static void main(String[] args) {
        
    }
}
