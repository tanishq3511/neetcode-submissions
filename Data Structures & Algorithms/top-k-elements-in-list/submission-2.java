class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length+1];

        for(int x = 0; x < frequency.length; x++){
            frequency[x] = new ArrayList<>();
        }

        for(int x = 0; x < nums.length; x++){
            // map.putIfAbsent(nums[x], 0);
            // map.put(nums[x], map.get(nums[x] + 1));

            map.put(nums[x], map.getOrDefault(nums[x], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for(int x = frequency.length - 1; x >= 0 && idx < k; x--){
            for(int n : frequency[x]){
                res[idx++] = n;
                if(idx == k){
                    return res;
                }
            }
        }
        return res;
    }
}
