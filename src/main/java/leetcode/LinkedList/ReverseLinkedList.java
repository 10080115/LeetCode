package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class ReverseLinkedList {
    //反转单链表
    //    3      -> 2 -> 1   -> 4      -> 5
    // tmpHead         head nextHead
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextHead = head.next;
        ListNode tmpHead  = head;
        while(head.next!=null){
            head.next = nextHead.next;
            nextHead.next = tmpHead;
            tmpHead=nextHead;
            nextHead = head.next;
        }
        return tmpHead;
    }
}
