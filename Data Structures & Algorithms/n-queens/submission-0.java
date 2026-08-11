class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                board[x][y] = '.';
            }
        }

        backtrack(board, n, 0);
        return res;
    }

    private void backtrack(char[][] board, int n, int numQueens){
        if(numQueens==n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int x=0; x< n; x++){
            if(isSafe(numQueens, x, board)){
                board[numQueens][x] = 'Q';
                backtrack(board, n, numQueens+1);
                board[numQueens][x] = '.';
            }
        }
    }

    private boolean isSafe(int x, int y, char[][] board){
        for(int i = 0; i < board.length; i++){
            if((board[x][i]=='Q' && i!=y) || (board[i][y]=='Q' && i!=x)){
                return false;
            }
        }
        for(int i = x-1, j = y-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i= x-1, j = y+1; i>=0 && j < board.length; i--, j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
}
