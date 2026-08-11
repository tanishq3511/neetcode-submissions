class Solution {
    public boolean isAnagram(String s, String t) {
        int[] seenChars = new int[26];

        for(int c = 0; c < s.length(); c++){
            seenChars[s.charAt(c) - 'a']++;
        }

        for(int c = 0; c < t.length(); c++){
            seenChars[t.charAt(c) - 'a']--;
        }

        for(int x : seenChars){
            if(x != 0){
                return false;
            }
        }

        return true;
    }
}
