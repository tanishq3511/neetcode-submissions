class Solution {
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, word1, word2);
    }

    private int dfs(int i, int j, String word1, String word2){
        if(j >= word2.length() && i >= word1.length()) return 0;

        if(j >= word2.length()) return word1.length() - i;

        if(i >= word1.length()) return word2.length() - j;

        if(memo[i][j] != -1) return memo[i][j];

        int res = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            res = Math.min(res, dfs(i+1, j+1, word1, word2));
        }else{
            res = Math.min(res, 1 + dfs(i+1, j, word1, word2));
            res = Math.min(res, 1 + dfs(i, j+1, word1, word2));
            res = Math.min(res, 1 + dfs(i+1, j+1, word1, word2));
        }

        memo[i][j] = res;
        return res;
    }
}
