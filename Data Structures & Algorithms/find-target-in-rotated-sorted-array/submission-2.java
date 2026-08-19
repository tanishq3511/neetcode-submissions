class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int cut = nums[0];
        int cutIndex = 0;

        while(l <= r){
            if(nums[l] < nums[r]){
                if(cut > nums[l]){
                    cut = nums[l];
                    cutIndex = l;
                }
                break;
            }

            int mid = (l + r) / 2;
            if(cut > nums[mid]){
                cut = nums[mid];
                cutIndex = mid;
            }
            if(nums[l] <= nums[mid]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        if(target <= nums[nums.length - 1]){
            l = cutIndex;
            r = nums.length - 1;
        }else{
            l = 0;
            r = cutIndex - 1;
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
