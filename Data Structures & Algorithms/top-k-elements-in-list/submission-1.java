class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for(int x = freq.length - 1; x > 0; x--){
            for(int y = 0; y < freq[x].size(); y++){
                res[idx++] = freq[x].get(y);
                if(idx == k){
                    return res;
                }
            }
        }

        return res;
    }
}
