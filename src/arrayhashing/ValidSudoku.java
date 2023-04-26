package arrayhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.' && !set.add(board[i][j])){
                    return false;
                }
            }
            set.clear();
        }
        set.clear();
        for(int i = 0; i <board.length; i++){
            for(int j = 0; j < board.length;j++){
                if(board[j][i] != '.' && !set.add(board[j][i])){
                    return false;
                }
            }
            set.clear();
        }
        set.clear();
        for(int i = 0 ; i < board.length; i=i+3){
            for(int j = 0; j < board.length; j=j+3){
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        if(board[k][l] != '.' && !set.add(board[k][l])){
                            return false;
                        }
                    }
                }
                set.clear();
            }
            set.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        v.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
}
