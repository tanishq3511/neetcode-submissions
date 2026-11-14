class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    maxIsland = Math.max(maxIsland, dfs(grid, r, c));
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        int res = 1;
        for(int[] d : dir){
            res += dfs(grid, r + d[0], c + d[1]);
        }

        return res;
    }
}
