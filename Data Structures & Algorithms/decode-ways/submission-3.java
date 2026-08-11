class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int x = s.length() -1; x>=0; x--){
            if(s.charAt(x)=='0'){
                dp[x] = 0;
            }else{
                dp[x] = dp[x+1];
                if(x+1 < s.length() && (s.charAt(x)=='1' || s.charAt(x)=='2' && s.charAt(x+1) < '7')){
                    dp[x] += dp[x+2];
                }
            }
        }

        return dp[0];
    }
}
