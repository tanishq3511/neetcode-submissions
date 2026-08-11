class Solution {
    public int rob(int[] nums) {
       int[] memo = new int[nums.length];
       Arrays.fill(memo, -1);

       return Math.max(dfs(0, memo, nums), dfs(1, memo, nums));
    }

    private int dfs(int n, int[] memo, int[] nums){
        if(n >= nums.length){
            return 0;
        }
        if(memo[n] != -1){
            return memo[n];
        }

        memo[n] = Math.max(nums[n] + dfs(n + 2, memo, nums), dfs(n+1, memo, nums));
        return memo[n];
    }
}
