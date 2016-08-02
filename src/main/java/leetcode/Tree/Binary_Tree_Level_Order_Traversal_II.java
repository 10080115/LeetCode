package leetcode.Tree;

/**
 * Created by lishiwei on 16/7/24.
 */
//Given a binary tree, return the bottom-up level order traversal of its nodes' values.
// (ie, from left to right, level by level from leaf to root).
// For example:
//Given binary tree [3,9,20,null,null,15,7],

import java.util.*;

/**
 * 3
 * / \
 * 9  20
 * / \
 * 15  7
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        List<Integer> list_num = new LinkedList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //记录本层节点个数
            int cur = 0;
            //本层结点的个数
            int last = queue.size();
            while (cur < last) {
                TreeNode current = queue.poll();
                list_num.add(current.val);
                cur++;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            list.add(list_num);
            list_num = new LinkedList<Integer>();
        }
        Collections.reverse(list);
        return list;
    }
}
