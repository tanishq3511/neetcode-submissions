class Solution {
    public void solve(char[][] board) {
        boolean[][] borderO = new boolean[board.length][board[0].length];

        for(int r = 0; r< board.length; r++){
            if(board[r][0]=='O'){
                dfs(board, borderO, r, 0);
            }
            if(board[r][board[0].length-1]=='O'){
                dfs(board, borderO, r, board[0].length-1);
            }
        }

        for(int c=0; c< board[0].length; c++){
            if(board[0][c]=='O'){
                dfs(board, borderO, 0, c);
            }
            if(board[board.length-1][c]=='O'){
                dfs(board, borderO, board.length-1, c);
            }
        }

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(!borderO[r][c] && board[r][c]=='O'){
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] bo, int r, int c){
        bo[r][c] = true;
        if(r-1>=0 && board[r-1][c]=='O' && !bo[r-1][c]){
            dfs(board, bo, r-1, c);
        }
        if(r+1<board.length && board[r+1][c]=='O' && !bo[r+1][c]){
            dfs(board, bo, r+1, c);
        }
        if(c-1>=0 && board[r][c-1]=='O' && !bo[r][c-1]){
            dfs(board, bo, r, c-1);
        }
        if(c+1<board[0].length && board[r][c+1]=='O' && !bo[r][c+1]){
            dfs(board, bo, r, c+1);
        }
    }
}
