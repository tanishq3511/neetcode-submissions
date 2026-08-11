class Solution {
    public int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == INF){
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }
    }  

    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        visit[r][c] = true;
        int steps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0; x< size; x++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if(grid[row][col] == 0){
                    return steps;
                }
                if(row + 1 < grid.length && !visit[row+1][col] && grid[row+1][col]!=-1){
                    visit[row+1][col] = true;
                    q.add(new int[]{row + 1, col});
                }
                if(row - 1 >=0 && !visit[row-1][col] && grid[row-1][col]!=-1){
                    visit[row-1][col] = true;
                    q.add(new int[]{row - 1, col});
                }
                if(col + 1 < grid[0].length && !visit[row][col+1] && grid[row][col+1]!=-1){
                    visit[row][col+1] = true;
                    q.add(new int[]{row, col+1});
                }
                if(col - 1 >=0 && !visit[row][col-1] && grid[row][col-1]!=-1){
                    visit[row][col-1] = true;
                    q.add(new int[]{row, col-1});
                }
            }
            steps++;
        }
        return INF;
    } 
}
