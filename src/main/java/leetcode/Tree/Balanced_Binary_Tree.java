package leetcode.Tree;

/**
 * Created by lishiwei on 16/7/24.
 */
public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }
}

