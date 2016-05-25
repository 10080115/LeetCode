package leetcode.Stack;

import java.util.Stack;

/**
 * Created by lishiwei on 16/4/27.
 */
public class MinStack {
    //每次存入栈里面2个值 一个是min 一个是当前值
    int min =  Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        if(x<min){
            min = x;
        }
        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        if(stack.pop()==min){
            stack.pop();
            if(stack.isEmpty())
                min = Integer.MAX_VALUE;
            else{
                min = stack.peek();
            }
        }
    }

    public int top() {
        int val = stack.pop();
        int top = stack.pop();
        stack.push(top);
        stack.push(val);
        return top;
    }

    public int getMin() {
        return stack.peek();
    }
}
