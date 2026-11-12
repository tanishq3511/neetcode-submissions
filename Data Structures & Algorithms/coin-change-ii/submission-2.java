class Solution {
    private int[][] memo;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        memo = new int[coins.length + 1][amount + 1];

        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return dfs(0, amount, coins);
    }

    private int dfs(int i, int amount, int[] coins){
        if(amount == 0) return 1;

        if(i >= coins.length) return 0;

        if(memo[i][amount] != -1) return memo[i][amount];

        int res = 0;
        if(amount >= coins[i]){
            res = dfs(i, amount - coins[i], coins) + dfs(i + 1, amount, coins);
        }
        memo[i][amount] = res;
        return res;
    }
}
