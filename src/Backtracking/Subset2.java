package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
//        backtracking(result, new ArrayList<>(), 0, nums);
        recursion(result, new ArrayList<>(), 0, nums, false);
//        for (List<Integer> list: result) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tmp, int index, int[] nums) {
        result.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            tmp.add(nums[i]);
            backtracking(result, tmp, i+1, nums);
            tmp.remove(tmp.size()-1);
        }
    }

    private void recursion(List<List<Integer>> result, List<Integer> tmp, int pos, int[] nums, boolean choosePre){
        System.out.println("In stack " + pos);
        if(pos == nums.length) {
            System.out.println("Touch the line. Will back to prev stack. The tmp list is: ");
            System.out.println(Arrays.toString(tmp.toArray()));
            result.add(new ArrayList<>(tmp));
            return;
        }
        System.out.println("Go to next stack");
        recursion(result, tmp, pos+1, nums, false);
        if(pos>=1 && nums[pos] == nums[pos-1] && !choosePre) {
            return;
        }
        System.out.println("Add item: " + nums[pos]);
        tmp.add(nums[pos]);
        recursion(result, tmp, pos+1, nums, true);
        System.out.println("Remove item: " + tmp.get(tmp.size()-1));
        tmp.remove(tmp.size()-1);

    }

    public static void main(String[] args) {
        Subset2 s = new Subset2();
        s.subsetsWithDup(new int[]{1,2,2});
    }


}
