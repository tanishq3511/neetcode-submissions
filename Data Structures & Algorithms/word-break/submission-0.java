class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int x = s.length() -1; x>=0; x--){
            for(String w : wordDict){
                if(x + w.length() <= s.length() && s.substring(x, x+w.length()).equals(w)){
                    dp[x] = dp[x+w.length()];
                }

                if(dp[x]){
                    break;
                }
            }
        }

        return dp[0];
    }
}
