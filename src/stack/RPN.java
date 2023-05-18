package stack;

import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str: tokens) {
            if(!"+".equals(str) && !"-".equals(str) && !"*".equals(str) && !"/".equals(str)){
                stack.push(str);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int value = 0;
                switch (str){
                    case "+":{
                        value = num1+num2;
                        break;
                    }
                    case "-":{
                        value = num1 - num2;
                        break;
                    }
                    case "*":{
                        value = num1 * num2;
                        break;
                    }
                    case "/": {
                        value = num1/num2;
                        break;
                    }
                }
                stack.push(String.valueOf(value));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        RPN r = new RPN();
        System.out.println(r.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
