class Solution {
    private int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t){
        if(i >= s.length()) return j >= t.length() ? 1 : 0;

        if(j >= t.length()) return 1;

        if(memo[i][j] != -1) return memo[i][j];

        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res += dfs(i + 1, j + 1, s, t);
        }

        res += dfs(i+1, j, s, t);

        memo[i][j] = res;
        return res;
    }
}
