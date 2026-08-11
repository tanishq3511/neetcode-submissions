class Solution {
    public String longestPalindrome(String s) {
        String substring = "";
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                int border = 1;
                while(i - border >= 0 && i + 1 + border < s.length() && s.charAt(i - border) == s.charAt(i + 1 + border)){
                    border++;
                }
                border--;
                if(2 + border*2 > maxLen){
                    maxLen = 2 + border*2;
                    substring = s.substring(i - border, i + 1 + border + 1);
                }
            }
            int border = 1;
            while(i - border >= 0 && i + border < s.length() && s.charAt(i - border) == s.charAt(i + border)){
                border++;
            }
            border--;
            if(1 + border*2 > maxLen){
                maxLen = 1 + border*2;
                substring = s.substring(i - border, i + border + 1);
            }
        }

        return substring;
    }
}
