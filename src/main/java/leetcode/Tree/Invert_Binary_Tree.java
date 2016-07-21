package leetcode.Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;

/**
 * Created by lishiwei on 16/7/20.
 */
public class Invert_Binary_Tree {
    //反转二叉树利用递归方法
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = root;
        if (temp == null) return root;

        if (temp.left != null || temp.right != null) {
            TreeNode tmp = temp.left;
            temp.left = invertTree(temp.right);
            temp.right = invertTree(tmp);
        }
        return root;
    }

    //反转二叉树利用层次遍历来解决
    public TreeNode inverTree2(TreeNode root) {
        if (root == null) return root;
        //从第二层才开始反转
        //第一次是两个
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.add(root);
        int cur, last;
        TreeNode temp;
        while (!linkedList.isEmpty()) {
            cur = 0;
            last = linkedList.size();
            while (cur < last) {
                temp = linkedList.poll();
                cur++;
                if (temp.left != null || temp.right != null) {
                    TreeNode tmp = temp.left;
                    temp.left = temp.right;
                    temp.right = tmp;
                }

                if (temp.left != null)
                    linkedList.add(temp.left);
                if (temp.right != null)
                    linkedList.add(temp.right);
            }
        }
        return root;
    }
}
