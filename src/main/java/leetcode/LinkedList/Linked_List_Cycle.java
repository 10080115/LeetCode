package leetcode.LinkedList;

/**
 * Created by lishiwei on 16/7/22.
 */

/*判断一个链表里面是不是有环*/
//前后两个链表点 分别向后移 一个每次动一部 一个每次动两部 看最后是否相交

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null)
            return false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
