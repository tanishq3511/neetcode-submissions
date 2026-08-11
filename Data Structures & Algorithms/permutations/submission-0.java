class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> member = new ArrayList<>();

        backtrack(member, nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<Integer> member, int[] nums, boolean[] pick){
        if(member.size()>= nums.length){
            res.add(new ArrayList<>(member));
            return;
        }
        for(int x = 0; x<nums.length; x++){
            if(!pick[x]){
                member.add(nums[x]);
                pick[x] = true;
                backtrack(member, nums, pick);
                pick[x] = false;
                member.remove(member.size()-1);
            }
        }
    }
}
