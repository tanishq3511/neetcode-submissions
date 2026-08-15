class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(l < r && !isAlphanumeric(s.charAt(l))){
                l++;
            }

            while(r > l && !isAlphanumeric(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public boolean isAlphanumeric(char c){
        if(c - 'a' >= 0 && c - 'z' <= 0){
            return true;
        }

        if(c - 'A' >= 0 && c - 'Z' <= 0){
            return true;
        }

        if(c - '0' >= 0 && c - '9' <= 0){
            return true;
        }

        return false;
    }
}
