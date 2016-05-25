package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeDfsBfs {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
        }
    }



    TreeNode root;

    public BinaryTreeDfsBfs(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public int depthOrderTraversal(){
        if(root==null){
            return 0;
        }
        int count = 0;
       Deque<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.left==null || node.right==null){
                break;
            }
            System.out.println("\n");
        }
        System.out.println(count+1);
        return 0;
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTreeDfsBfs tree=new BinaryTreeDfsBfs(arr);
        tree.depthOrderTraversal();
        //tree.levelOrderTraversal();
    }

    /**
     * Created by lishiwei on 16/4/26.
     */
    public static class PalindromeNumber {

        //利用字符串反向添加处理
        public boolean isPalindrome(int x) {
            String y = String.valueOf(x);
            String res = new String();
            for (int i = 0; i <y.length() ; i++) {
                res = y.charAt(i)+res;
            }
            return res.equals(y);
        }

        public boolean test(leetcode.TreeNode root, int val){
            Deque<leetcode.TreeNode> queue = new LinkedList<leetcode.TreeNode>();
            queue.add(root);
            int res = 0;
            if(!queue.isEmpty()){
                res = res + queue.peek().val;
                if (res==val)
                    return true;
                leetcode.TreeNode temp = queue.pop();
                int tempVal = temp.val;
                res -= tempVal;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            return false;
        }
    }
}