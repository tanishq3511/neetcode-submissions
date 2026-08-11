class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            res++;
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                res++;
                int border = 1;
                while(i - border >= 0 && i + 1 + border < s.length() && s.charAt(i - border) == s.charAt(i + 1 + border)){
                    border++;
                    res++;
                }

            }
            int border = 1;
            while(i - border >= 0 && i + border < s.length() && s.charAt(i - border) == s.charAt(i + border)){
                border++;
                res++;
            }
        }

        return res;
    }
}
