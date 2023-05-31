package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        for(int i = 0 ; i < arr.length; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        // sort position decrease to know what car most nearer the destination.
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int i = 1; i < arr.length; i++){
            // calculate time that the car arrive at the destination.
            double currentTime = (double) (target - arr[i][0])/arr[i][1];

            // compare time arrive of two car (or two car fleets). if
            if(!stack.isEmpty() && currentTime <= stack.peek()){
                continue;
            }else{
                stack.push(currentTime);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet c = new CarFleet();
        System.out.println((c.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3})));
    }
}
