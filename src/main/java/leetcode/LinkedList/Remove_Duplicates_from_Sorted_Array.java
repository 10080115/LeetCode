package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//        Do not allocate extra space for another array, you must do this in place with constant memory.
//        For example, Given input array A = [1,1,2],
//        Your function should return length = 2, and A is now [1,2].
//返回头节点即可
public class Remove_Duplicates_from_Sorted_Array {
    public ListNode delete_Duplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val)
                temp.next = temp.next.next;
            if (temp.next != null && temp.val != temp.next.val)
                temp = temp.next;
        }
        return head;
    }
}
