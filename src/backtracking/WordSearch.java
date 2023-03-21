package backtracking;

public class WordSearch {
    private static final int[][] routine = {{1,0},{-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == word.charAt(0)){
                    if(backtracking(board, word, 0, row, col, check)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int deep, int row, int col, boolean[][] check){
        if(deep == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if(check[row][col]){
            return false;
        }
        if(board[row][col] != word.charAt(deep)){
            return false;
        }
        check[row][col] = true;
        for(int[] r : routine){
            int newRow = row + r[0];
            int newCol = col + r[1];
            if(backtracking(board, word, deep + 1, newRow, newCol, check)){
                return true;
            }
        }
        check[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = {{'A','B', 'C', 'E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(w.exist(board, "ABCED"));
    }
}
