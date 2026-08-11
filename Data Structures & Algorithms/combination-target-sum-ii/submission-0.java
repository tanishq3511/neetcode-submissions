class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> member = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, res, member, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> member, int idx){
        if(target == 0){
            res.add(new ArrayList(member));
            return;
        }else if(idx >= candidates.length || target < 0){
            return;
        }

        member.add(candidates[idx]);
        dfs(candidates, target-candidates[idx], res, member, idx+1);
        member.remove(member.size()-1);

        while(idx + 1 < candidates.length && candidates[idx]==candidates[idx+1]){
            idx++;
        }
        dfs(candidates, target, res, member, idx+1);
    }
}
