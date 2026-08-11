class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int s = 0; s < strs.length; s++){
            int[] count = new int[26];

            for(int c = 0; c < strs[s].length(); c++){
                count[strs[s].charAt(c) - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[s]);
        }

        return new ArrayList<>(map.values());
    }
}
