class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxSub = 1;

        for(int x = 0; x < nums.length; x++){
            for(int y = x - 1; y >= 0; y--){
                if(nums[x] > nums[y]){
                    dp[x] = Math.max(dp[x], dp[y] + 1);
                    maxSub = Math.max(maxSub, dp[x]);
                }
            }
        }

        return maxSub;
    }
}
