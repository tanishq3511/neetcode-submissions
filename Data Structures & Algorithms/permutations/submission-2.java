class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, used, set);
        return res;
    }

    private void dfs(int[] nums, int i, boolean[] used, List<Integer> set){
        if(i == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }
        
        for(int x = 0; x < used.length; x++){
            if(!used[x]){
                set.add(nums[x]);
                used[x] = true;
                dfs(nums, i + 1, used, set);
                set.remove(set.size() - 1);
                used[x] = false;
            }
        }
    }
}
