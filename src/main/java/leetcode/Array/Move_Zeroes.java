package leetcode.Array;

/**
 * Created by lishiwei on 16/7/20.
 */
public class Move_Zeroes {
    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
    //You must do this in-place without making a copy of the array.
    //Minimize the total number of operations.

    //现将非0得
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insertPos = 0;

        for (int num : nums)
            if (num != 0) nums[insertPos++] = num;

        while (insertPos < nums.length)
            nums[insertPos++] = 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 12, 0, 0, 9};
        new Move_Zeroes().moveZeroes(arr);
        for (int a : arr)
            System.out.print(" " + a);
    }
}
