class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int x = 0; x<board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(backtrack(board, visited, word, 0, x, y)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, String word, int idx, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(idx) || visited[row][col]){
            return false;
        }
        if(idx == word.length() - 1){
            return true;
        }
        visited[row][col] = true;
        boolean res =  backtrack(board, visited, word, idx+1, row - 1, col) || backtrack(board, visited, word, idx+1, row + 1, col) || backtrack(board, visited, word, idx+1, row, col-1) || backtrack(board, visited, word, idx+1, row, col+1);
        visited[row][col] = false;
        return res;
    } 
}
