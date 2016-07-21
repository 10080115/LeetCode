package leetcode.Array;

/**
 * Created by lishiwei on 16/7/12.
 */
//Follow up for ”Remove Duplicates”:
// What if duplicates are allowed at most twice? For example, Given sorted array A = [1,1,1,2,2,3],
// Your function should return length = 5, and A is now [1,1,2,2,3]
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates_II(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_II().removeDuplicates_II(arr));
    }
}
