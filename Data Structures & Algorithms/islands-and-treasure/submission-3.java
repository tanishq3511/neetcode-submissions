class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length; 
        int cols = grid[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0) q.add(new int[]{r, c});
            }
        }
        if(q.size() == 0) return;

        while(!q.isEmpty()){
            int[] coord = q.poll();
            int r = coord[0];
            int c = coord[1];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }

                q.add(new int[]{nr, nc});

                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}
