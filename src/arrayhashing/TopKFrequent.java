package arrayhashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(!result.containsKey(nums[i])){
                result.put(nums[i], 0);
            }
            int frequent = result.get(nums[i]);
            result.put(nums[i], frequent);
        }
        Stream<Map.Entry<Integer, Integer>> sorted = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).co;
        return
    }
}
