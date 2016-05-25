package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * Created by lishiwei on 16/4/27.
 */
public class IntersectionOfTwoLinkedLists {
    //找到2个链表的交点 因为是单链表一定是y相交 找到两个链表的长度差 一个链表先走 一个链表后
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 1;
        int lenB = 1;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA.next != null) {
            tmpA = tmpA.next;
            lenA++;
        }

        while (tmpB.next != null) {
            tmpB = tmpB.next;
            lenB++;
        }

        if (tmpA != tmpB)
            return null;

        int bu = lenA - lenB;
        tmpA = headA;
        tmpB = headB;
        if (bu > 0) {
            for (int i = 0; i < bu; i++) {
                tmpA = tmpA.next;
            }
        } else {
            for (int i = 0; i < -bu; i++) {
                tmpB = tmpB.next;
            }
        }
        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return tmpA;
    }
}
