class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 == 1){
            return false;
        }

        int target = sum/2;
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int x = 0; x < nums.length; x++){
            HashSet<Integer> nextDP = new HashSet<>();
            for(int val : dp){
                if(nums[x] + val == target){
                    return true;
                }
                nextDP.add(val);
                if(nums[x] + val < target) nextDP.add(nums[x] + val);
            }

            dp = nextDP;
        }

        return false;
    }
}
