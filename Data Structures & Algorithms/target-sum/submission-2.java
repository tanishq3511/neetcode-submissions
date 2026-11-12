class Solution {
    int[][] memo;
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int n : nums) totalSum += n;

        memo = new int[nums.length][2*totalSum + 1];

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 2*totalSum + 1; j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }

        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int sum, int[] nums, int target){
        if(i == nums.length) return sum == target ? 1 : 0;

        if(memo[i][sum + totalSum] != Integer.MIN_VALUE) return memo[i][sum + totalSum];

        memo[i][sum + totalSum] = dfs(i+1, sum - nums[i], nums, target) + dfs(i+1, sum + nums[i], nums, target);

        return memo[i][sum + totalSum];
    }
}
