package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static final String[] PAIR = {"(", ")"};
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "");
        return result;
    }

    private void backtracking(List<String> result, String tmp){
        if(tmp.length() == 16 && isValid(tmp)){
            result.add(new String(tmp));
            return;
        }
        if(tmp.length() == 16 && !isValid(tmp)){{
            return;
        }}
        for(int i = 0 ; i < PAIR.length; i++){
            tmp += PAIR[i];
            backtracking(result, tmp);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }

    private boolean isValid(String s) {
        if(s == null || s.isEmpty() || s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(c == '('){
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
        }
        if(stack.size()>0) {
            return false;
        }
        return true;
    }

    public List<String> generateParenthesisVer2(int n){
        List<String> result = new ArrayList<>();
        backtrackingVer2(result, n, 0,0, "");
        return result;
    }

    private void backtrackingVer2(List<String> result, int n, int open, int close, String tmp) {
        if(tmp.length() == 2*n){
            result.add(tmp);
            return;
        }
        if(open < n){
            backtrackingVer2(result, n, open+1, close, tmp+"(");
        }
        if(close < open){
            backtrackingVer2(result, n, open, close+1, tmp +")");
        }
    }


    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
//        System.out.println(Arrays.toString(g.generateParenthesis(8).toArray()));
        System.out.println(Arrays.toString(g.generateParenthesisVer2(3).toArray()));
    }
}
