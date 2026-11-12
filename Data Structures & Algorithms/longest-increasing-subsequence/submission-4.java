class Solution {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    private int dfs(int[] nums, int i){
        if(memo[i] != -1) return memo[i];

        int longest = 1;
        for(int j = i; j < nums.length; j++){
            if(nums[i] < nums[j]){
                longest = Math.max(longest, 1 + dfs(nums, j));
            }
        }
        memo[i] = longest;
        return memo[i];
    }
}
