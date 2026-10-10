class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;

            if(i > 0 && nums[i-1] == nums[i])continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = nums[i];

            while(l < r){
                if(target + nums[l] + nums[r] == 0){
                    res.add(Arrays.asList(target, nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                }else if(target + nums[l] + nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}
