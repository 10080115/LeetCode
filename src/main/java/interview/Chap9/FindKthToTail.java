package interview.Chap9;

/**
 * Created by lishiwei on 16/4/19.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKthToTail {


    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        for(int i = 0;i <k ;i++){
            if(p1==null)
                return null;
            p1 = p1.next;
        }


        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
