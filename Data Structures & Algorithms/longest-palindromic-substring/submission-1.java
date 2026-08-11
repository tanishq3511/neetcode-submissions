class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0; 
        int resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for(int x = n-1; x>=0; x--){
            for(int y = x; y < n; y++){
                if(s.charAt(x) == s.charAt(y) && (y-x <= 2 || dp[x+1][y-1])){
                    dp[x][y] = true;
                    if(resLen < (y-x+1)){
                        resIdx = x;
                        resLen = y-x+1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}
