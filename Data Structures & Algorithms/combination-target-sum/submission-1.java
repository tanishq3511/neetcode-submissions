class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        dfs(nums, 0, 0, target, set, res);
        return res;
    }

    private void dfs(int[] nums, int i, int sum, int target, List<Integer> set, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(set));
            return;
        }

        if(i == nums.length || sum > target) return;

        set.add(nums[i]);
        dfs(nums, i, sum + nums[i], target, set, res);
        set.remove(set.size() - 1);
        dfs(nums, i + 1, sum, target, set, res);
    }
}
