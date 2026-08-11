class Solution {
    int[][] dp;
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        for(int num : nums){
            totalSum += num;
        }

        dp = new int[n][2*totalSum+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2*totalSum+1; j++){
                dp[i][j] = 2*totalSum + 1;
            }
        }

        return backtrack(0, 0, target, nums);
    }

    private int backtrack(int i, int sum, int target, int[] nums){
        if(i == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        if(dp[i][sum + totalSum] != 2*totalSum + 1){
            return dp[i][sum + totalSum];
        }

        dp[i][sum + totalSum] = backtrack(i+1, sum + nums[i], target, nums) + backtrack(i+1, sum - nums[i], target, nums);
        return dp[i][sum + totalSum];
    }
}
