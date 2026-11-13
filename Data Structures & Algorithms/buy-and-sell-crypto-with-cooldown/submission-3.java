class Solution {
    int[][] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }

        return dfs(0, 1, prices);
    }

    private int dfs(int i, int canBuy, int[] prices){
        if(i >= prices.length) return 0;

        if(memo[i][canBuy] != -1) return memo[i][canBuy];

        int cooldown = dfs(i + 1, canBuy, prices);
        if(canBuy == 1){
            int buy = dfs(i + 1, 0, prices) - prices[i];
            memo[i][canBuy] = Math.max(cooldown, buy);
        }else{
            int sell = dfs(i+2, 1, prices) + prices[i];
            memo[i][canBuy] = Math.max(cooldown, sell);
        }

        return memo[i][canBuy];
    }
}
