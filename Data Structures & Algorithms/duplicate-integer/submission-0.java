class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x=0; x<nums.length; x++){
            if(!set.add(nums[x])){
                return true;
            }
        }
        return false;
    }
}
