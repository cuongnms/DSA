package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtracking(result, n, 0, new ArrayList<>());
        for(List<String> l: result){
            System.out.println(Arrays.toString(l.toArray()));
        }
        return result;

    }

    private void backtracking(List<List<String>> result, int size, int rowToPlace, List<String> tmp) {
        if(rowToPlace==size){
            result.add(new ArrayList<>(tmp));
        }else{
            for(int col = 0 ; col < size; col++){
                if(tryPlace(col, rowToPlace, tmp)){
                    String queenIndex = place(col, size);
                    tmp.add(queenIndex);
                    backtracking(result, size, rowToPlace+1, tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    private boolean tryPlace(int col, int row, List<String> tmp){
        for(int i = 0 ; i < tmp.size(); i++){
            if(tmp.get(i).indexOf("Q") == col){
                return false;
            }
            if(tmp.get(i).indexOf("Q") - col > 0 && row - i == tmp.get(i).indexOf("Q") - col){
                return false;
            }
            if(col - tmp.get(i).indexOf("Q") > 0 && row - i == col - tmp.get(i).indexOf("Q")){
                return false;
            }
        }
        return true;
    }

    private String place(int index, int size){
        String place = "";
        for(int i = 0 ; i < size; i++){
            if(index == i){
                place+="Q";
            }else{
                place+=".";
            }
        }
        return place;
    }

    public static void main(String[] args) {
        Queen q = new Queen();
        q.solveNQueens(4);
    }
}
