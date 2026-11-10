class Solution {

    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int i, int n, char[][] board){
        if(i==n){
            List<String> sol = new ArrayList<>();
            for(char[] row : board){
                sol.add(new String(row));
            }
            res.add(sol);
            return;
        }

        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(i+c) || negDiag.contains(i-c)){
                continue;
            }

            col.add(c);
            posDiag.add(i+c);
            negDiag.add(i-c);
            board[i][c] = 'Q';

            backtrack(i + 1, n, board);

            col.remove(c);
            posDiag.remove(i+c);
            negDiag.remove(i-c);
            board[i][c] = '.';
        }
    }
}
