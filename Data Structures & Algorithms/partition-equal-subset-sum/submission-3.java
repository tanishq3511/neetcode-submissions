class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;

        if(sum %2 == 1) return false;

        memo = new Boolean[nums.length][sum/2 + 1];


        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int[] nums, int i, int sum){
        if(i == nums.length) return sum == 0;

        if(sum < 0) return false;

        if(memo[i][sum] != null) return memo[i][sum];

        memo[i][sum] = dfs(nums, i + 1, sum - nums[i]) || dfs(nums, i + 1, sum);
        return memo[i][sum];
    }
}
