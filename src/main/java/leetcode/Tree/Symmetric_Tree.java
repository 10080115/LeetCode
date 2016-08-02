package leetcode.Tree;

/**
 * Created by lishiwei on 16/7/24.
 */
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return ifSymmetric(root.left, root.right);
    }

    public boolean ifSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null)
            return false;
        if (right == null)
            return false;
        if (left.val != right.val)
            return false;
        else
            return ifSymmetric(left.left, right.right) && ifSymmetric(left.right, right.left);
    }
}
