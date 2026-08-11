class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = coins.length-1; i>=0; i--){
            int[] nextDP = new int[amount+1];
            nextDP[0] = 1;

            for(int x = 1; x<=amount; x++){
                nextDP[x] = dp[x];
                if(x-coins[i] >=0 ){
                    nextDP[x] += nextDP[x-coins[i]];
                }
            }

            dp = nextDP;
        }

        return dp[amount];
    }
}
