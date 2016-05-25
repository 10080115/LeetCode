package interview.Chap9;

/**
 * Created by lishiwei on 16/4/19.
 */
public class Partition {
    ListNode beforeStart = null;
     ListNode beforeEnd = null;
     ListNode afterStart = null;
     ListNode afterEnd = null;

    public static void main(String[] args) {
    }
     public ListNode  partition(ListNode node, int x){
        while (node!=null){
            if(node.val<x){
                if(beforeEnd==null) {
                    beforeStart = node;
                    beforeEnd = node;
                }
                else
                    beforeEnd.next  = node;
                    beforeEnd = node;
            }else{
                if(afterStart==null) {
                    afterStart = node;
                    afterEnd = afterStart;
                }
                else{
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = node.next;
        }
         beforeEnd.next = afterStart;
         return beforeStart;
     }
}
