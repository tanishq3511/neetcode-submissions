class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(0, 0, n, "");
        return res;
    }

    private void dfs(int open, int closed, int n, String set){
        if(open + closed == n*2){
            res.add(set);
            return;
        }

        if(open < n){
            set += "(";
            dfs(open + 1, closed, n, set);
            set = set.substring(0, set.length() - 1);
        }

        if(closed < open){
            set += ')';
            dfs(open, closed + 1, n, set);
            set =  set.substring(0, set.length() - 1);
        }
    }
}
