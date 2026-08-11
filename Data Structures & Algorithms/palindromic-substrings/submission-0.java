class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int x=0; x<s.length(); x++){
            int l = x;
            int r = x;

            while(l >=0 && r <s.length() && s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }

        for(int x=1; x<s.length(); x++){
            int l = x-1;
            int r = x;
            while(l >=0 && r <s.length() && s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}
