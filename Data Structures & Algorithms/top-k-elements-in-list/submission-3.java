class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;

        for(int i = nums.length; i > 0; i--){
            for(int num : frequency[i]){
                res[idx++] = num;
                if(idx == k){
                    return res;
                }
            }
        }
        return res;
    }
}
