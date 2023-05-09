package twopointer;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int firstIndex = 0 ; firstIndex < nums.length-2; firstIndex++){
            int secondIndex = firstIndex+1;
            int thirdIndex = nums.length-1;
            for(;secondIndex<thirdIndex;){
                int sum = nums[firstIndex] + nums[secondIndex] + nums[thirdIndex];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[thirdIndex]));
                    thirdIndex--;
                    secondIndex++;
                }else if(sum > 0){
                    thirdIndex--;
                }else if(sum < 0){
                    secondIndex++;
                }
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
