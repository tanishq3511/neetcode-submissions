class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int x = m-1; x >= 0; x--){
            for(int y = n-1; y >= 0; y--){
                if(x>0) dp[x-1][y] += dp[x][y];
                if(y>0) dp[x][y-1] += dp[x][y];
            }
        }

        return dp[0][0];
    }
}
