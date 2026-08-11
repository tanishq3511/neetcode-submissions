class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();

        for(int x=0; x<nums.length; x++){
            if(nums[x]>0){
                break;
            }else if(x>0 && nums[x]==nums[x-1]){
                continue;
            }

            int start = x+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[x]+nums[start]+nums[end]==0){
                    sol.add(Arrays.asList(nums[x], nums[start], nums[end]));
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                }else if(nums[x]+nums[start]+nums[end]>0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return sol;
    }
}
