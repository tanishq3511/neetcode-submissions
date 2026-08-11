class Solution {
    int[][] directions = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int lip = 0;
        dp = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                dp[row][col] = -1;
            }
        }

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                lip = Math.max(lip, dfs(matrix, row, col, Integer.MIN_VALUE));
            }
        }

        return lip;
    }

    private int dfs(int[][] matrix, int row, int col, int prevVal){
        if(row < 0 || row >=matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prevVal){
            return 0;
        }
        if(dp[row][col] != -1) return dp[row][col];

        int res = 1; 
        for(int[] d : directions){
            res = Math.max(res, 1 + dfs(matrix, row + d[0], col + d[1], matrix[row][col]));
        }

        return dp[row][col] = res;
    }
}
