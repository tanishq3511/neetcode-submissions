class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int x = 1; x<=amount; x++){
            for(int y=0; y < coins.length; y++){
                if(coins[y]<=x){
                    dp[x] = Math.min(dp[x], dp[x-coins[y]]+1);
                }
            }
        }

        if(dp[amount] > amount){
            return -1;
        }

        return dp[amount];
    }
}
