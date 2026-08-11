class Solution {
    int[][] dp;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int lip = 0;
        dp = new int[matrix.length][matrix[0].length];

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                dp[x][y] = -1;
            }
        }

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                lip = Math.max(lip, dfs(matrix, x, y, Integer.MIN_VALUE));
            }
        }

        return lip;
    }

    private int dfs(int[][] matrix, int row, int col, int prevVal){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prevVal){
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int res = 1;
        for(int[] dir : directions){
            res = Math.max(res, 1 + dfs(matrix, row + dir[0], col + dir[1], matrix[row][col]));
        }

        return dp[row][col] = res;
    }
}
