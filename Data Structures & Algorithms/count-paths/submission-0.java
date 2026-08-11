class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        
        for(int x = m-1; x>=0; x--){
            for(int y = n-1; y>=0; y--){
                dp[x][y] += dp[x+1][y] + dp[x][y+1];
            }
        }

        return dp[0][0];
    }
}
