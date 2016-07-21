package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

import static leetcode.Array.qucik_sort.quick_sort;

/**
 * Created by lishiwei on 16/7/13.
 */
public class Sum_Three {
    public List<List<Integer>> threeSum(int[] nums) {

        quick_sort(nums, 0, nums.length - 1);
        int i, j = nums.length - 1;
        //两个指针相向移动
        List list;
        List<List<Integer>> list_list = new ArrayList<List<Integer>>();
        for (int k = 0; k < nums.length; k++) {
            i = k + 1;
            while (i < j) {
                if (k != i && k != j) {
                    System.out.println(i + " " + j + " " + k);
                    if (nums[k] + nums[i] + nums[j] > 0)
                        j--;
                    else if (nums[k] + nums[i] + nums[j] < 0)
                        i++;
                    else {
                        list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!list_list.contains(list))
                            list_list.add(list);
                        i++;
                        j--;
                    }
                }
                if (k == i)
                    i++;
                if (k == j)
                    j--;
            }
        }
        return list_list;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(new Sum_Three().threeSum(nums));
    }
}
