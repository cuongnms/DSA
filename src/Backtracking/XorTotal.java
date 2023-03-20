package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XorTotal {
    public int subsetXORSum(int[] nums) {
        int sum = backtracking(nums, 0,  new ArrayList<>());
        sum = recursion(nums, 0, 0);
        return sum;

    }

    private int backtracking(int[] nums, int level, List<Integer> tmp){
        int sum = xor(tmp);
        for(int i = level; i < nums.length; i++){
            tmp.add(nums[i]);
            sum += backtracking(nums, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
        return sum;
    }
    private int recursion(int[] nums, int level, int sum){
        if(level == nums.length){
            return sum;
        }
        int sumOfElementPicked = recursion(nums, level+1, sum ^ nums[level]);
        int sumOfWithoutElementPicked = recursion(nums, level + 1, sum);
        return sumOfElementPicked + sumOfWithoutElementPicked;
    }

    private int xor(List<Integer> nums){
        int sum = 0;
        for(int i = 0 ; i < nums.size(); i++){
            sum = sum ^ nums.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        XorTotal x= new XorTotal();
        System.out.println(x.subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}
