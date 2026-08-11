class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anaMap = new HashMap<>();

        for(String s : strs){
            int[] countChars = new int[26];
            for(char c : s.toCharArray()){
                countChars[c - 'a']++;
            }
            String key = Arrays.toString(countChars);
            anaMap.putIfAbsent(key, new ArrayList<String>());
            anaMap.get(key).add(s);
        }

        return new ArrayList<>(anaMap.values());
    }
}
