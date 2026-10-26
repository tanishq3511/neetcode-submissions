class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length - 1;

        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] <= nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        int cut = nums[l];
        int cutIndex = l;

        if(target > nums[nums.length - 1]){
            l = 0;
            r = cutIndex - 1;
        }else{
            l = cutIndex;
            r = nums.length - 1;
        }

        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            } 
        }

        return -1;
    }
}
