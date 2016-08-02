package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lishiwei on 16/7/27.
 */
//层次遍历二叉树
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tmp_val_list = new ArrayList<Integer>();
        LinkedList<TreeNode> tmp_node_list = new LinkedList<TreeNode>();
        if (root == null) return list;
        int cur = 0, size = 1;
        tmp_node_list.add(root);
        tmp_val_list.add(root.val);
        list.add(tmp_val_list);
        tmp_val_list = new ArrayList<Integer>();
        while (tmp_node_list.size() != 0)

        {
            cur = 0;
            size = tmp_node_list.size();
            while (cur < size) {
                TreeNode tmp = tmp_node_list.poll();
                if (tmp.left != null) {
                    tmp_node_list.add(tmp.left);
                    tmp_val_list.add(tmp.left.val);
                }
                if (tmp.right != null) {
                    tmp_node_list.add(tmp.right);
                    tmp_val_list.add(tmp.right.val);
                }
                cur++;
            }
            if (tmp_node_list.size() == 0)
                break;
            list.add(tmp_val_list);
            tmp_val_list = new ArrayList<Integer>();
        }
        return list;
    }
}
