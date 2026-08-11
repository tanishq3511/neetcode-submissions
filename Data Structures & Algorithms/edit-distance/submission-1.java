class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        for(int x = 0; x< word1.length(); x++){
            Arrays.fill(dp[x], -1);
        }

        return dfs(word1, word2, 0, 0);
    }

    public int dfs(String word1, String word2, int i, int j){
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = dfs(word1, word2, i + 1, j + 1);
        }else{
            int res = Math.min(dfs(word1, word2, i + 1, j), dfs(word1, word2, i, j+1));
            res = Math.min(res, dfs(word1, word2, i + 1, j + 1));
            dp[i][j] = res + 1;
        }

        return dp[i][j];
    }
}
