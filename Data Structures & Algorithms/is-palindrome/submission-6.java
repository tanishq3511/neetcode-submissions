class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int start = 0;
        int end = str.length()-1;
        
        while(start<end){
            while(start<end && (str.charAt(start)-'a'<0 || str.charAt(start)-'z'>0) && (str.charAt(start)-'0'<0 || str.charAt(start)-'9'>0)){
                start++;
            }
            while(end>start && (str.charAt(end)-'a'<0 || str.charAt(end)-'z'>0) && (str.charAt(end)-'0'<0 || str.charAt(end)-'9'>0)){
                end--;
            }
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
