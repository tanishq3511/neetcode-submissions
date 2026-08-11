class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x = 0; x < nums.length; x++){
            int diff = target - nums[x];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), x};
            }
            map.put(nums[x], x);
        }

        return new int[] {-1, -1};
    }
}
