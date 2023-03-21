package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Queen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtracking(result, n, 0, new ArrayList<>());
        return result;

    }

    private void backtracking(List<List<String>> result, int size, int rowToPlace, List<String> tmp) {
        if(rowToPlace==size){
            result.add(new ArrayList<>(tmp));
        }else{
            for(int i = 0 ; i < 4; i++){
                if(tryPlace(i, rowToPlace, tmp)){
                    String queenIndex = place(i);
                    tmp.add(queenIndex);
                }
            }
        }
    }

    private boolean tryPlace(int col, int row, List<String> tmp){
        for(int i = 0 ; i < tmp.size(); i++){
            if(tmp.get(i).indexOf("Q") == col){
                return false;
            }
            if(tmp.get(i).indexOf("Q") - row >= 0 ){
                return false;
            }
        }
        return true;
    }

    private String place(int index){
        String place = "";
        for(int i = 0 ; i < 4; i++){
            if(index == i){
                place+="Q";
            }else{
                place+=".";
            }
        }
        return place;
    }
}
