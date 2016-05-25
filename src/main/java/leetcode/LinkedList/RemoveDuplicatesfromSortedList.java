package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode temp = head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
            if(temp==null)
                break;
        }
        return head;
    }
}
