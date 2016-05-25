package leetcode.Stack;

import java.util.Stack;

/**
 * Created by lishiwei on 16/4/27.
 */
public class ImplementQueueUsingStacks {
    // Push element x to the back of queue.
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int x) {
        //添加元素
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(empty())
            return;
        else if(!out.isEmpty())
            out.pop();
        else if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            out.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!out.isEmpty())
            return out.peek();
        else{
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }
    }


    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
