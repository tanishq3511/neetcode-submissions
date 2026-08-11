class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int x = 0; x < strs.length; x++){
            int[] numChars = new int[26];
            for(int y = 0; y < strs[x].length(); y++){
                numChars[strs[x].charAt(y) - 'a']++;
            }
            String code = Arrays.toString(numChars);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(strs[x]);
        }

        return new ArrayList<>(map.values());
    }
}
