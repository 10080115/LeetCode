package leetcode.LinkedList;

import leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lishiwei on 16/4/25.
 */

//1 -> 2 -> 3 -> 4
//give you 3
//return 1 -> 2 -> 4

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node==null || node.next==null)
            return;
        node.val=node.next.val;
        node.next = node.next.next;
    }
}
