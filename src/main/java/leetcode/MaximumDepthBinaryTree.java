package leetcode;

import java.util.*;

/**
 * Created by lishiwei on 16/4/23.
 */
public class MaximumDepthBinaryTree {

    //recursive
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return ((Math.max(maxDepth(root.left),maxDepth(root.right)))+1);
    }

    //non recursive
    public int maxDepth2(TreeNode root){
        if(root==null)
            return 0;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode tmp = queue.pop();
                if(tmp.left==null || tmp.right==null)
                  return count;
                queue.add(root.left);
                queue.add(root.right);
            }
            count++;
        }
        return count;
    }
}
