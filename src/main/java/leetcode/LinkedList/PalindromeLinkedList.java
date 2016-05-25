package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class PalindromeLinkedList {
    //将后一般的链表进行反转就行了
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null)
            return true;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //证明是就奇数个节点
        if(fast != null) slow = slow.next;
        //之后就是反转单链表
        if(slow==null)
            return true;
        slow = reverse(slow);
        while(slow!=null){
            if(slow.val==head.val){
                slow = slow.next;
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
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
