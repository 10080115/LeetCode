package leetcode;

/**
 * Created by lishiwei on 16/4/25.
 */
public class MoveZeroes {
    //nums = [0, 1, 0, 3, 12]
    //nums = [1,3,12,0,0]

    public void moveZeroes(int[] nums) {
        int count = 0;
        if(nums.length==0 || nums==null)
            return;
        for(int i =0; i<=nums.length-1;i++){
            if(nums[i]!=0) nums[count++] = nums[i];
        }

        for(int i=count;i<=nums.length-1;i++){
            nums[i] = 0;
        }
    }
}
