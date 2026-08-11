class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> member = new ArrayList<>();

        backtrack(member, s, 0);
        return res;
    }

    private void backtrack(List<String> member, String s, int idx){
        if(idx>= s.length()){
            res.add(new ArrayList<>(member));
            return;
        }

        for(int j = idx; j< s.length(); j++){
            if(isPalindrome(s, idx, j)){
                member.add(s.substring(idx, j+1));
                backtrack(member, s, j+1);
                member.remove(member.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            r--;
            l++;
        }

        return true;
    }
}
