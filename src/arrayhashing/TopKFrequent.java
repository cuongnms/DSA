package arrayhashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(!result.containsKey(nums[i])){
                result.put(nums[i], 0);
            }
            int frequent = result.get(nums[i]) + 1;
            result.put(nums[i], frequent);
        }
        List<Integer> sorted = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).collect(Collectors.toList()).subList(0,k);
        int[] arr = new int[k];
        for(int i = 0 ; i < sorted.size(); i++){
            arr[0] = sorted.get(0);
        }
        return arr;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        t.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
