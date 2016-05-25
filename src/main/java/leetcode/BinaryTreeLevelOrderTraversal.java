package leetcode;

import java.util.*;

/**
 * Created by lishiwei on 16/4/23.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> container = new ArrayList<List<Integer>>();
        if (root == null) return container;
        Deque<TreeNode> levelNode = new LinkedList<TreeNode>();
        List<Integer> levelNum = new LinkedList<Integer>();
        levelNum.add(root.val);
        levelNode.add(root);
        container.add(0,levelNum);
        levelNum = new LinkedList<Integer>();
        while(!levelNode.isEmpty()){
            int size = levelNode.size();
            while(size-->0){
                TreeNode tmp = levelNode.pop();
                if(tmp.left!=null){
                    levelNode.add(tmp.left);
                    levelNum.add(tmp.left.val);
                }
                if(tmp.right!=null){
                    levelNode.add(tmp.right);
                    levelNum.add(tmp.right.val);
                }
            }
            if(levelNum.size()!=0)
                container.add(0,levelNum);
            levelNum = new LinkedList<Integer>();
        }
        return container;
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().levelOrderBottom(null);
    }
}
