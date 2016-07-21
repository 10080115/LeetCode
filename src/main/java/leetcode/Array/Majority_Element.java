package leetcode.Array;

/**
 * Created by lishiwei on 16/7/21.
 */
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.
//出现最多的数占据了超过半壁江山

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int max_num = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max_num)
                count++;
            else {
                count--;
                if (count == 0) {
                    max_num = nums[i];
                    count = 1;
                }
            }
        }
        return max_num;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 1, 1, 1};
        System.out.println(new Majority_Element().majorityElement(arr));
    }
}
