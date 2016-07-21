package leetcode.Tree;


import java.util.LinkedList;

/**
 * Created by lishiwei on 16/7/20.
 */

/*
    linkedlist arraylist 都是实现了list接口 list接口又实现了collection接口 又实现了 iterable接口
    linkedlist 又实现了queue接口

    add：Inserts the specified element at the specified position in this list
    将指定的元素插入到list中指定的的位置。返回的是boolean类型的
    offer：Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
    如果在不违反容量限制的情况下，尽可能快的将指定的元素插入到queue中去
 */

public class Maximum_Depth_of_Binary_Tree {
    //递归的方法 非递归的方法计算
    public int maxDepth_r(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth_r(root.left), maxDepth_r(root.right)) + 1;
    }

    //非递归的方法 计算二叉树的最大高度 利用层次遍历的方法进行计算
    //层次遍历利用一个队列来存储节点 cur 和 last 记录个数
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //记录一个工作结点
        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //add是list的方法
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            //记录本层节点个数
            cur = 0;
            //本层结点的个数
            last = queue.size();
            while (cur < last) {
                current = queue.poll();
                cur++;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            level++;
        }
        return level;
    }
}