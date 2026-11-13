class Solution {
    private Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p){
        if(j == p.length()) return i == s.length();

        if(memo[i][j] != null) return memo[i][j];

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < p.length() && p.charAt(j+1) == '*'){
            memo[i][j] = dfs(i, j+2, s, p) || (match && dfs(i+1, j, s, p));
        }else{
            memo[i][j] = match && dfs(i+1, j+1, s, p);
        }

        return memo[i][j];
    }
}
