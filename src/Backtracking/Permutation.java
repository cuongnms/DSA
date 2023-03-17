package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null){
            return new ArrayList<>();
        }
        if(nums.length ==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, List<Integer> tmp){
        if(tmp.size() == nums.length){
            System.out.println(Arrays.toString(tmp.toArray()));
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(tmp.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            backtracking(result, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<List<Integer>> result = p.permute(new int[]{1,2,3});
    }
}
