package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class SwapNodesInPairs {
    //交换键值对
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            int swap = temp.val;
            temp.val=temp.next.val;
            temp.next.val = swap;
            temp = temp.next.next;
        }
        return head;
    }
}
