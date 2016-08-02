package leetcode.LinkedList;

/**
 * Created by lishiwei on 16/7/23.
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3 = l2;
        ListNode l4 = l1;
        while (true) {
            l1.next = l2.next;
            l2.next = l1;
            if (l4 != null)
                l4 = l1;
            if (l1.next == null)
                break;
            else
                l1 = l1.next;
            if (l1.next == null) {
                break;
            } else {
                l2 = l1.next;
            }
            l4.next = l2;
        }
        return l3;
    }
}
