package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length ==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, 0, candidates, target, new ArrayList<>());
        for(List<Integer> list : result){
            System.out.println(Arrays.toString(list.toArray()));
        }
        return result;
    }

    private void backtracking(List<List<Integer>> result, int index, int[] candidates, int target, List<Integer> tmp){
//        if(target == 0){
//            result.add(new ArrayList<>(tmp));
//            return;
//        }
//        if(target < 0){
//            return;
//        }
//        for(int i = index; i < candidates.length; i++){
//            if(i>index && candidates[i]==candidates[i-1]){
//                continue;
//            }
//            if(target - candidates[i] >= 0){
//                tmp.add(candidates[i]);
//                backtracking(result, i+1, candidates, target - candidates[i], tmp);
//                tmp.remove(tmp.size()-1);
//            }
//        }

    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5);
    }

}
