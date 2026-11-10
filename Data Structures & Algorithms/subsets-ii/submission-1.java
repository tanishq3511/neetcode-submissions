class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, set);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> set){
        if(i >= nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        dfs(nums, i + 1, set);

        set.remove(set.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;
        dfs(nums, i + 1, set);
    }
}
