package leetcode.String;

import java.util.Stack;

/**
 * Created by lishiwei on 16/7/27.
 */
//实现队列用栈
public class Implement_Queue_using_Stacks {
    //You must use only standard operations of a stack --
    //which means only push to top, peek/pop from top, size, and is empty operations are valid.
    //push(x) -- Push element x to the back of queue.
    //pop() -- Removes the element from in front of queue.
    //peek() -- Get the front element.
    //empty() -- Return whether the queue is empty.
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            stack2.pop();
        } else {
            stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
}
