package leetcode.LinkedList;

/**
 * Created by lishiwei on 16/7/22.
 */
/*
Given a sorted linked list,
delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next == null)
                break;
            if (tmp.val == tmp.next.val)
                tmp.next = tmp.next.next;
            else
                tmp = tmp.next;
        }
        return head;
    }
}
