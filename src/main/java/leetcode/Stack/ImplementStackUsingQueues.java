package leetcode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lishiwei on 16/4/27.
 */
public class ImplementStackUsingQueues {
    //利用2个队列实现栈 将1的元素 再放入2 再添加新元素再将2中的放回1
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    //代表从1里面出数据
    // Push element x onto stack.
    void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }
    }
    // Removes the element on top of the stack.
    void pop() {
        if(queue1.isEmpty()){
            return;
        }
        queue1.remove();
    }

    // Get the top element.
    int top() {
        return queue1.peek();
    }

    // Return whether the stack is empty.
    boolean empty() {
        return queue1.isEmpty();
    }
}
