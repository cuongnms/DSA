package arrayhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> list = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(list.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = list.get(target - nums[i]);
                return result;
            }else{
                list.put(nums[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum  = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2,4}, 6)));
    }
}
