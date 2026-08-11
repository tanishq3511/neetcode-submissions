class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x = 0; x < nums.length; x++){
            int pair = target - nums[x];
            if(map.containsKey(pair)){
                return new int[]{map.get(pair), x};
            }

            map.put(nums[x], x);
        }

        return new int[]{-1, -1};
    }
}
