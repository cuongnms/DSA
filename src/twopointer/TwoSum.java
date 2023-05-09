package twopointer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;
        int[] result = new int[2];
        for(;firstIndex < lastIndex;){
            if(numbers[firstIndex] + numbers[lastIndex] > target){
                lastIndex--;
            }else if(numbers[firstIndex] + numbers[lastIndex] < target){
                firstIndex++;
            }else if(numbers[firstIndex] + numbers[lastIndex] == target){
                result[0] = firstIndex +1;
                result[1] = lastIndex +1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2,5,7,9,11}, 9)));
    }
}
