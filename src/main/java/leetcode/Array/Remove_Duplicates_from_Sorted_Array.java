package leetcode.Array;

/**
 * Created by lishiwei on 16/7/12.
 */
public class Remove_Duplicates_from_Sorted_Array {
    //    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//    Do not allocate extra space for another array, you must do this in place with constant memory.
//    For example, Given input array A = [1,1,2],
//    Your function should return length = 2, and A is now [1,2].
    public int removeDuplicates(int[] nums) {
        int id = 1;
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] != nums[i - 1])
                nums[id++] = nums[i];
        }
        return id;
    }
}
