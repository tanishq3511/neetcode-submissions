class Solution {
    int[][] memo;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                memo[r][c] = -1;
            }
        }

        int max = 0;
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                max = Math.max(max, dfs(r, c, matrix, Integer.MIN_VALUE));
            }
        }

        return max;
    }

    private int dfs(int r, int c, int[][] matrix, int prev){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] <= prev){
            return 0;
        }

        if(memo[r][c] != -1) return memo[r][c];

        int res = 1;
        for(int[] d : directions){
            res = Math.max(res, 1 + dfs(r + d[0], c + d[1], matrix, matrix[r][c]));
        }

        memo[r][c] = res;
        return res;
    }
}
