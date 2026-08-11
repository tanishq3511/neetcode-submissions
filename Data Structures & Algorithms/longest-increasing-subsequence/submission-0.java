class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for(int x = nums.length-1; x>=0; x--){
            for(int y = x+1; y < nums.length; y++){
                if(nums[x] < nums[y]){
                    LIS[x] = Math.max(LIS[x], 1 + LIS[y]);
                }
            }
        }
        int maxSub = LIS[0];
        for(int x=1; x<nums.length; x++){
            if(LIS[x] > maxSub){
                maxSub = LIS[x];
            }
        }

        return maxSub;
    }
}
