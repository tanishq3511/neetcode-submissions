class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] stChars = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            stChars[s.charAt(i) - 'a']++;
            stChars[t.charAt(i) - 'a']--;
        }

        for(int x : stChars){
            if(x != 0){
                return false;
            }
        }

        return true;
    }
}
