class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i+1] = nums[i];
        }

        memo = new int[n+2][n+2];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return dfs(1, newNums.length - 2, newNums);
    }

    private int dfs(int l, int r, int[] nums){
        if(l > r) return 0;

        if(memo[l][r] != -1) return memo[l][r];

        memo[l][r] = 0;

        for(int i = l; i <= r; i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];

            coins += dfs(l, i - 1, nums) + dfs(i+1, r, nums);
            memo[l][r] = Math.max(memo[l][r], coins);
        }

        return memo[l][r];
    }
}

