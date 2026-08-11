class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;

        dp = new int[s.length()][t.length()];

        for(int x = 0; x < s.length(); x++){
            for(int y = 0; y < t.length(); y++){
                dp[x][y] = -1;
            }
        }

        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res += dfs(s, t, i + 1, j + 1);
        }

        res += dfs(s, t, i + 1, j);

        return dp[i][j] = res;
    }
}
