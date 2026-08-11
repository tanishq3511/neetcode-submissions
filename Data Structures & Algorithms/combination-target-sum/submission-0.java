class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> member = new ArrayList<>();

        backtrack(nums, target, res, member, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> member, int idx){
        if(target == 0){
            res.add(new ArrayList(member));
            return;
        }else if(target < 0 || idx >=nums.length){
            return;
        }

        member.add(nums[idx]);
        backtrack(nums, target - nums[idx], res, member, idx);
        member.remove(member.size()-1);
        backtrack(nums, target, res, member, idx+1);
        
    }
}
