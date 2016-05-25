package leetcode;

import java.util.*;

 class TreeNode {
    public TreeNode(int val){
        this.val = val;
    }
    public int getVal() {
        return val;
    }

    int val;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode left;

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode right;
}

class TreeVisit{
    static TreeNode root;

    static {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        d.left = null;
        d.right = null;
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        g.left = null;
        g.right = null;
        TreeNode h = new TreeNode(8);
        h.left = null;
        h.right = null;
        c.left = null;
        f.left = null;
        f.right = null;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        e.right = h;
        c.right = f;
        root = a;
    }


    //层序遍历
    public static void leverlOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root!=null)
            queue.add(root);

        //代表的是队列不为空的情况下
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }


    //遍历指定行的元素
    public static int leverlOrder2(TreeNode root, int level){

        if(root==null || level < 0)
            return 0;
        else if(level == 0) {
            System.out.print(root.val);
            return 1;
        }
        else {
            return leverlOrder2(root.left, level - 1) + leverlOrder2(root.right, level - 1);
        }
    }

    //先序遍历二叉树
    public static void preOrder(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }else{
            return;
        }
    }

    //中序遍历二叉树
    public static void order(TreeNode root){
        if (!(root==null)){
            order(root.left);
            System.out.println(root.val);
            order(root.right);
        }else{
            return;
        }
    }

    //后序遍历二叉树
    public static void posOrder(TreeNode root){
        if(!(root==null)){
            posOrder(root.left);
            posOrder(root.right);
            System.out.println(root.val);
        }else {
            return;
        }

    }

    //非递归前序遍历
    public static void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();

       while (root!=null || !stack.empty()){
           while (root!=null){
               stack.push(root);
               System.out.println(root.val);
               root = root.left;
           }

           if(!stack.empty()){
               root=stack.pop();
               root=root.right;
           }

       }
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int c = 0;
        for(int i = n-1; i>=0;i--){
            int val = 0;
            if(i==n-1)
                val = digits[i] + 1;
            else
                val = digits[i] + c;
            if(val>=10){
                c  =  1;
                val = val%10;
            }else{
                c = 0;
            }
            digits[i] = val;
            System.out.println(digits[i]);
            if(i==0 && c!=0){
                System.out.println("Coming");
                int arr2[] = new int[n+1];
                arr2[0] =1;
                for(int j=1;j<n;j++){
                    arr2[j]=digits[j];
                }
                digits = arr2;
            }
        }
        return null;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        int[] nums = new int[3];
            List<List<Integer>> container = new ArrayList<List<Integer>>();

            if (root == null) return container;
            TreeNode cur = null;
            Queue<TreeNode> sameLevel = new LinkedList<TreeNode>();
            sameLevel.add(root);
            while(!sameLevel.isEmpty()){
                List<Integer> oneLevel = new ArrayList<Integer>();
                Queue<TreeNode> temp = new LinkedList<TreeNode>();
                while(!sameLevel.isEmpty()){
                    cur = sameLevel.remove();
                    oneLevel.add(cur.val);
                    if(cur.left!=null) temp.add(cur.left);
                    if(cur.right!=null) temp.add(cur.right);
                }
                container.add(0,oneLevel);
                sameLevel = temp;
            }
            return container;
        }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> container = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        level.add(1);
        if(numRows==1){
            container.add(0,level);
            return container;
        }
        container.add(0,level);
        int count = 1;
        for(int i = 2;i<numRows;i++){
            List<Integer> level2= new ArrayList<Integer>();
            level2.add(1);
            for(int j=1;j<=i;j++){
                if((i-j)==1){
                    level2.add(1);
                }else if((i-j)!=1 && level2.size()<i){
                    level2.add(level.get(j) + level.get(j+1));
                }
            }
            level2.add(1);
            container.add(count++,level2);
            level=level2;
        }
        return container;
    }

        public static int removeDuplicates(int[] nums) {
            int count = 0;
            int pos = 0;
            int flag = 0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]-nums[i]==0){
                    if(flag==0) {
                        flag = 1;
                        pos++;
                    }
                    count++;
                }else{
                    if(i==0)
                        nums[pos] = nums[i];
                    else if(nums[i]!=nums[i-1])
                        nums[pos] = nums[i];
                    if(i==0 || nums[i]!=nums[i-1])
                        pos++;
                    flag = 0;
                }
            }
            System.out.println(nums[0]+" "+nums[1]+" "+nums[2]+" "+nums[3]+" "+nums[4]);
            return nums.length-count;
        }

    public static boolean isPowerOfFour(int num) {
        double a = Math.sqrt(num);
        if(a*a-num!=0)
            return false;
        if(num==1)
            return true;
        if(num==0)
            return false;
        return ( (num & (num-1))==0 && ((num&num+1)!=0));
    }
    public static void main(String[] args) {
       // leverlOrder(root);
       //leverlOrder2(root,0);
        // preOrder(root);
       // order(root);
       // posOrder(root);
        //preOrder2(root);
       //int []arr = {1,2,4,4,5,5,6};
        //removeDuplicates(arr);
        //System.out.println(1^1);
        System.out.println(isPowerOfFour(8));
    }
}

