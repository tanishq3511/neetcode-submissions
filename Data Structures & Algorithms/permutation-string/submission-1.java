class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int x= 0; x< s1.length(); x++){
            s1count[s1.charAt(x)-'a']++;
            s2count[s2.charAt(x)-'a']++;
        }
        
        int matches = 0;
        for(int x=0; x<26; x++){
            if(s1count[x]==s2count[x]){
                matches++;
            }
        }

        int l = 0;
        for(int r= s1.length(); r<s2.length(); r++){
            if(matches==26){
                return true;
            }

            int idx = s2.charAt(r)-'a';
            s2count[idx]++;
            if(s1count[idx] == s2count[idx]){
                matches++;
            }else if(s1count[idx] + 1 == s2count[idx]){
                matches--;
            }
            idx = s2.charAt(l) - 'a';
            s2count[idx]--;
            if (s1count[idx] == s2count[idx]) {
                matches++;
            } else if (s1count[idx] - 1 == s2count[idx]) {
                matches--;
            }
            l++;
        }

        if(matches==26){
            return true;
        }
        return false;
    }
}
