package stack;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty() || s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(c == ')'){
                if(!stack.contains('(')){
                    return false;
                }
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
            if(c == ']'){
                if(!stack.contains('[')){
                    return false;
                }
                if(!stack.isEmpty() && stack.peek()== '['){
                    stack.pop();
                }
            }
            if(c == '}'){
                if(!stack.contains('{')){
                    return false;
                }
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }
            }
        }
        if(stack.size()>0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("(])"));
    }

}
