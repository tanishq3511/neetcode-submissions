class Solution {

    List<String> res;
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.equals("")) return res;
        String sub = "";
        dfs(0, digits, sub);
        return res;
    }

    private void dfs(int i, String digits, String sub){
        if(i == digits.length()){
            res.add(sub);
            return;
        }

        String combos = arr[digits.charAt(i)-'1' + 1];
        for(int x = 0; x < combos.length(); x++){
            sub += combos.substring(x, x+1);
            dfs(i+1, digits, sub);
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}
