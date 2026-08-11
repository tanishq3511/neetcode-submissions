class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int x = m-1; x>=0; x--){
            for(int y = n-1; y>=0; y--){
                if(text1.charAt(x)==text2.charAt(y)){
                    dp[x][y] = 1 + dp[x+1][y+1];
                }else{
                    dp[x][y] = Math.max(dp[x+1][y], dp[x][y+1]);
                }
            }
        }

        return dp[0][0];
    }
}
