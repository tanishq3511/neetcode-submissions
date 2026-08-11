class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int x=n-1; x>=0; x--){
            for(int buying = 0; buying <= 1; buying++){
                if(buying==1){
                    int buy = dp[x+1][0] - prices[x];
                    int cooldown = dp[x+1][1];
                    dp[x][1] = Math.max(buy, cooldown);
                }else{
                    int sell = prices[x];
                    if(x+2<n){
                        sell += dp[x+2][1];
                    }
                    int cooldown = dp[x+1][0];
                    dp[x][0] = Math.max(sell, cooldown);
                }
            }
        }

        return dp[0][1];
    }
}
