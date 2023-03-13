package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {

    /*
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, 0);
        for (List<Integer> list: result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tmpResult, int[] nums, int index){
        result.add(new ArrayList<>(tmpResult));
        for(int i = index; i < nums.length; i++){
            tmpResult.add(nums[i]);
            backtracking(result, tmpResult, nums, i + 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        subset.subsets(new int[]{1,2,3});
    }
}
