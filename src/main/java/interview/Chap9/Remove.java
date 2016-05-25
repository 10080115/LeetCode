package interview.Chap9;

/**
 * Created by lishiwei on 16/4/19.
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if(pNode.next==null)
            return false;
        else{
            while(pNode.next.next!=null)
                pNode.val = pNode.next.val;
            pNode.next = null;
            return true;
        }
    }
}
