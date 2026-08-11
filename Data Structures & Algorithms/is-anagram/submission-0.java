class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        // char[] sSorted = s.toCharArray();
        // char[] tSorted = t.toCharArray();

        // Arrays.sort(sSorted);
        // Arrays.sort(tSorted);

        // return Arrays.equals(sSorted, tSorted);

        int[] countChars = new int[26];

        for(int x=0; x<s.length(); x++){
            countChars[s.charAt(x)-'a']++;
            countChars[t.charAt(x) -'a']--;
        }

        for(int value : countChars){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
}
