class Solution {
    public int trap(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 0;
        suffix[nums.length - 1] = 0;

        for(int i = 1; i < nums.length - 1; i++){
            prefix[i] = Math.max(prefix[i-1], nums[i-1]);
            suffix[nums.length - 1 - i] = Math.max(suffix[nums.length - i], nums[nums.length - i]);
        }

        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += Math.max(0, Math.min(prefix[i], suffix[i]) - nums[i]);
        }

        return total;
    }
}
