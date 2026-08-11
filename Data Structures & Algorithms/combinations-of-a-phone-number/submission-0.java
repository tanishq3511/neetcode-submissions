class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if(digits.length()==0){
            return res;
        }

        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int idx, String member){
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(idx >= digits.length()){
            res.add(member);
            return;
        }

        String combos = digitToChar[digits.charAt(idx)-'0'];

        for(int x=0; x< combos.length(); x++){
            member += combos.charAt(x);
            backtrack(digits, idx+1, member);
            member = member.substring(0, member.length()-1);
        }
    }
}
