package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2!=null) return l2;
        else if(l1!=null && l2==null) return l1;
        else if(l1==null && l2==null) return l1;
        ListNode head = null;
        if(l1.val<=l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        ListNode temp = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1!=null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2!=null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }
}