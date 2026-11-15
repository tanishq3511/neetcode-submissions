class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length; 
        int cols = grid[0].length;

        int numFresh = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2) q.add(new int[]{r, c});
                if(grid[r][c] == 1) numFresh++;
            }
        }

        int time = 0;
        while(!q.isEmpty() && numFresh > 0){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        numFresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }

        return numFresh == 0 ? time : -1;
    }
}
