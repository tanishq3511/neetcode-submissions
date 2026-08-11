class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] vals = new int[2];
        // int end = nums.length - 1;
        // int start = 0;

        // while(nums[start]+nums[end]!=target && start!=end){
        //     if(nums[start]+nums[end]>target){
        //         end--;
        //     }else{
        //         start++;
        //     }
        // }

        // vals[0] = start;
        // vals[1] = end;
        
        // return vals;

        HashMap<Integer, Integer> keyMap = new HashMap<Integer, Integer>();

        for(int x=0; x<nums.length; x++){
            int diff = target - nums[x];
            if(keyMap.containsKey(diff)){
                return new int[] {keyMap.get(diff), x};
            }
            keyMap.put(nums[x], x);
        }

        return new int[] {};
    }
}
