package leetcode.Stack;

import java.util.Stack;

/**
 * Created by lishiwei on 16/4/27.
 */
public class ValidParentheses {
    //{}()[]判断合理性利用stack
    public boolean isValid(String s) {
        if(s==null || s.length()==0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)=='(')||(s.charAt(i)=='[')||(s.charAt(i)=='{')) {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(s.charAt(i)==')'){
                if(stack.pop()!='('){
                    return false;
                }
            }
            if(s.charAt(i)==']'){
                if(stack.pop()!='['){
                    return false;
                }
            }
            if(s.charAt(i)=='}'){
                if(stack.pop()!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
