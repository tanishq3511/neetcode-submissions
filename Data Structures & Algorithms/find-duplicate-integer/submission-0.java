class Solution {
    public int findDuplicate(int[] nums) {
        for(int x=0; x<nums.length; x++){
            if(nums[Math.abs(nums[x])]<0){
                return Math.abs(nums[x]);
            }else{
                nums[Math.abs(nums[x])] *=-1;
            }
        }
        return -1;
    }
}
