class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] freqArr = new List[nums.length+1];

        for(int x=0; x<freqArr.length; x++){
            freqArr[x] = new ArrayList<>();
        }

        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            freqArr[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int x= freqArr.length-1; x>=0 && index<k; x--){
            for(int n : freqArr[x]){
                result[index++] = n;
                if(index==k){
                    return result;
                }
            }
        }

        return result;
    }
}
