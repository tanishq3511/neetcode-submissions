class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int smallest = nums[0];

        while(l<=r){
            if(nums[l]<nums[r]){
                smallest = Math.min(smallest, nums[l]);
                break;
            }

            int mid = l + (r-l)/2;
            smallest = Math.min(smallest, nums[mid]);
            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return smallest;
    }
}
