class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset  = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> subset, List<List<Integer>> res){
        if(idx >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        dfs(nums, idx+1, subset, res);
        subset.remove(subset.size()-1);
        dfs(nums, idx+1, subset, res);
    }
}
