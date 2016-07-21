package leetcode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lishiwei on 16/7/20.
 */
/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

定义了一个hashset来存元素
 */
public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet2 = new HashSet<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();

        for (int num : nums1)
            hashSet.add(num);

        for (int num : nums2) {
            if (hashSet.contains(num))
                hashSet2.add(num);
        }

        int[] result = new int[hashSet2.size()];
        int i = 0;
        for (Integer num : hashSet2)
            result[i++] = num;

        return result;
    }
}
