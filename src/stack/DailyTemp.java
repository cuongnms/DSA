package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {
    /*
    * Create stack for save index of temperature that have temperature lower than current temp in loop.
    * */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]){
                int indexOfResult = stack.pop();
                result[indexOfResult] = i - indexOfResult;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemp d = new DailyTemp();
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
