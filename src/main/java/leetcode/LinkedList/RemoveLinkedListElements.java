package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class RemoveLinkedListElements {
    //Example
    //Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    //Return: 1 --> 2 --> 3 --> 4 --> 5
    public ListNode removeElements(ListNode head, int val) {
        while(head==null)
            return null;
        ListNode temp = head;
        while(temp.next!=null){
            if(temp.next.val==val) temp.next = temp.next.next;
            else temp = temp.next ;
        }
        return head.val == val?head.next:head;
    }
}
