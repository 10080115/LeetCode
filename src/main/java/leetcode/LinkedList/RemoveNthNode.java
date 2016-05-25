package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class RemoveNthNode {
    //删除倒数第n个元素
    //先让前边那个元素移动N步
    //当前边那个节点到达末尾即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        ListNode a = head;
        ListNode b = head;
        for(int i=0;i<n;i++){
            a = a.next;
        }
        if(a==null){
            head=b.next;
            return head;
        }
        while(a.next!=null){
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return head;
    }
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while((fast!=null)||(fast.next==null)){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
