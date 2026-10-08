class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] numChars = new int[26];
            for(int s = 0; s < strs[i].length(); s++){
                numChars[strs[i].charAt(s) - 'a']++;
            }

            String code = Arrays.toString(numChars);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
