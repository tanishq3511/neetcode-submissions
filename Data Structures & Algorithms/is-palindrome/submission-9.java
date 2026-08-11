class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while(l<r){
            while(l < r && !(s.charAt(l) - 'a' >= 0 && s.charAt(l) - 'z' <= 0) && !(s.charAt(l) - '0' >= 0 && s.charAt(l) - '9' <= 0)){
                l++;
            }
            while(l < r && !(s.charAt(r) - 'a' >= 0 && s.charAt(r) - 'z' <= 0) && !(s.charAt(r) - '0' >= 0 && s.charAt(r) - '9' <= 0)){
                r--;
            }

            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
