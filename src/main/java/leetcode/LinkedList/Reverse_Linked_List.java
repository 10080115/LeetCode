package leetcode.LinkedList;

/**
 * Created by lishiwei on 16/7/21.
 */
//单链表反转
public class Reverse_Linked_List {
    //递归方法
    ListNode reverseList_r(ListNode head) {
        if (head == null || head.next == null) return head;
        //新的头节点
        ListNode newHead = reverseList_r(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        //新的头节点
        ListNode next_head = head.next;
        ListNode fact_head = head;
        while (head.next != null) {
            head.next = next_head.next;
            next_head.next = fact_head;
            fact_head = next_head;
            next_head = head.next;
        }
        return fact_head;
    }

}
