class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet set = new HashSet<Integer>();

        for(int x : nums){
            if(!set.add(x)){
                return true;
            }
        }

        return false;
    }
}