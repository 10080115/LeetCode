package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lishiwei on 16/4/25.
 */
public class InvertBinaryTree {
    //deque
    //尽量利用offer进行插入
    //利用poll进行删除元素
    //利用栈进行深度优先遍历
//    public TreeNode invertTree(TreeNode root) {
//        if(root==null)
//            return null;
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode tmp = stack.pop();
//            TreeNode left = tmp.left;
//            TreeNode right = tmp.right;
//            //swap
//            tmp.left = right;
//            tmp.right = left;
//            if(tmp.left!=null)
//                stack.push(tmp.left);
//            if(tmp.right!=null)
//                stack.push(tmp.right);
//        }
//        return root;
//    }

    //反转二叉树
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.right;
        root.right = invertTree2(root.left);
        root.left = invertTree2(temp);
        return root;
    }

    public static void main(String[] args) {
    }
}
