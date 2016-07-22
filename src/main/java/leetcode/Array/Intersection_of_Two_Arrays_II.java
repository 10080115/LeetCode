package leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lishiwei on 16/7/21.
 */

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection_of_Two_Arrays_II {
    //这个是利用hashmap 存key count
    //再用第二个数组去第一个里面减key的count 减到0为止
    //出现的值加入到list当中
    //遍历为数组即可
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        //存入的hashmap是 key 和 key出现的次数
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i]))
                hashMap.put(nums1[i], 1 + hashMap.get(nums1[i]));
            else
                hashMap.put(nums1[i], 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i]))
                if (hashMap.get(nums2[i]) > 0) {
                    hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
                    list.add(nums2[i]);
                }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}
