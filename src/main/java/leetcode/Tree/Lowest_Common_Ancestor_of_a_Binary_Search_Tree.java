package leetcode.Tree;

/**
 * Created by lishiwei on 16/7/22.
 */

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”
 */
// 2 and 8 is 6 && 2 and 4 is 2
// 二插排序树
// 二插排序树 如果p、q的值都小于根的值那么就是左边
// 二插排序树 如果p、q的值都小于根的值那么就是右边
// 要不然就是这个节点
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val > p.val && tmp.val > q.val)
                tmp = tmp.left;
            else if (tmp.val < p.val && tmp.val < q.val)
                tmp = tmp.right;
            else
                return tmp;
        }
        return null;
    }
}
