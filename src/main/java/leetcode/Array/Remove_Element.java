package leetcode.Array;

/**
 * Created by lishiwei on 16/7/24.
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] == val && nums[right] == val) {
                right--;
                count -= 2;
            } else if (nums[left] == val && nums[right] != val) {
                swap(nums, left, right);
                count -= 1;
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
        return count;
    }

    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    public void swap(int[] nums, int left, int right) {
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
    }
}
