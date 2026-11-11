class Solution {
    private int[][] memo;

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        memo = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }

        return dfs(0, 0, nums);
    }

    private int dfs(int i, int flag, int[] nums){
        if(i >= nums.length || (flag == 1 && i == nums.length - 1)) return 0;

        if(memo[i][flag] != -1) return memo[i][flag];

        int flag2 = (flag == 1 || i == 0) ? 1 : 0;

        int skip = dfs(i + 1, flag, nums);
        
        int rob = nums[i] + dfs(i + 2, flag2, nums);

        memo[i][flag] = Math.max(skip, rob);

        return memo[i][flag];
    }
}
