package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class OddEvenLinkedList {
    //Given 1->2->3->4->5->NULL,
    //return 1->3->5->2->4->NULL.
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode oddLast = head;
        ListNode evenHead = head.next;
        ListNode evenLast = head.next;
        ListNode temp = head.next.next;
        int  pos = 1;
        while(temp!=null){
            if(pos%2==0){
                evenLast.next=temp;
                evenLast = evenLast.next;
            }else{
                oddLast.next=temp;
                oddLast =oddLast.next;
            }
            pos++;
            temp = temp.next;
        }
        evenLast.next = null;
        oddLast.next = evenHead;
        return head;
    }

}
