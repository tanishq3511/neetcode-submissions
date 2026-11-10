class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, set, res);
        return res;
    }

    private void dfs(int[] nums, int i, int sum, int target, List<Integer> set, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(set));
            return;
        }

        if(i == nums.length || sum > target) return;

        set.add(nums[i]);
        dfs(nums, i + 1, sum + nums[i], target, set, res);
        set.remove(set.size() - 1);

        while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        dfs(nums, i + 1, sum, target, set, res);
    }
}
