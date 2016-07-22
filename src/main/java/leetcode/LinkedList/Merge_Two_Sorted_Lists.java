package leetcode.LinkedList;

/**
 * Created by lishiwei on 16/7/22.
 */

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
 */

public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode tmp;
        if (l1.val < l2.val) {
            tmp = l1;
            l1 = l1.next;
        } else {
            tmp = l2;
            l2 = l2.next;
        }
        //依次取数
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
        }
        return null;
    }
}
