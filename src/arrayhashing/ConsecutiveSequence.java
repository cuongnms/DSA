package arrayhashing;

import java.util.*;

public class ConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int max = 1;
        for (Integer value: set) {
            if(!set.contains(value - 1)){
                int nextValue = value+1;
                while(set.contains(nextValue)){
                    nextValue++;
                }
                max = Math.max(max, nextValue-value);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ConsecutiveSequence c = new ConsecutiveSequence();
        System.out.println(c.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}

