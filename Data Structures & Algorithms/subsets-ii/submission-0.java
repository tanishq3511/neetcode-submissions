class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> member = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(member, nums, 0);
        return res;
    }

    private void backtrack(List<Integer> member, int[] nums, int idx){
        if(idx == nums.length){
            res.add(new ArrayList<>(member));
            return;
        }

        member.add(nums[idx]);
        backtrack(member, nums, idx+1);
        member.remove(member.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        backtrack(member, nums, idx+1);
    }
}
