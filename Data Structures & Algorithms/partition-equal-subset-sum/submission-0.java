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
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int x = nums.length-1; x>=0; x--){
            Set<Integer> nextDP = new HashSet<>();
            for(int t : dp){
                if(t + nums[x] == target){
                    return true;
                }

                nextDP.add(t);
                if(t + nums[x] < target){
                    nextDP.add(t + nums[x]);
                }
            }
            dp = nextDP;
        }

        return false;
    }
}
