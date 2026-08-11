class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> dupeRow = new HashSet<Character>();
        HashSet<Character> dupeCol = new HashSet<Character>();
        HashSet<Character> dupeSqr = new HashSet<Character>();


        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[x].length; y++){
                if(board[x][y]!='.' && !dupeRow.add(board[x][y])){
                    return false;
                }
                if(board[y][x]!='.' && !dupeCol.add(board[y][x])){
                    return false;
                }

            }
            dupeRow.clear();
            dupeCol.clear();
        }
        
        for(int x=0; x<9; x++){
            for(int y=0; y<3; y++){
                for(int z=0; z<3; z++){
                    int row = (x/3) * 3 + y;
                    int col = (x%3) * 3 + z;
                    if(board[row][col]!='.' && !dupeSqr.add(board[row][col])){
                        return false;
                    }
                }
            }
            dupeSqr.clear();
        }

        return true;
    }
}
