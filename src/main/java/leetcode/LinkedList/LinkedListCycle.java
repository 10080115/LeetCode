package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while((fast!=null)&&(fast.next!=null)){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
