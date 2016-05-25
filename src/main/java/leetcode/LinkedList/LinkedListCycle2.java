package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = hasCycle(head);
        ListNode temp2 = head;
        if(temp==null)
            return temp;
        while(temp!=temp2){
            temp=temp.next;
            temp2=temp2.next;
        }
        return temp;
    }
    public ListNode hasCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while((fast!=null)&&(fast.next!=null)){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return fast;
        }
        return null;
    }
}
