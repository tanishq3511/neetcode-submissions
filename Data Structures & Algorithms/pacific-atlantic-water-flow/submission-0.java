class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        for(int c=0; c<heights[0].length; c++){
            dfs(0, c, pac, heights);
            dfs(heights.length-1, c, atl, heights);
        }

        for(int r=0; r<heights.length; r++){
            dfs(r, 0, pac, heights);
            dfs(r, heights[0].length-1, atl, heights);
        }

        for(int r=0; r<heights.length; r++){
            for(int c=0; c<heights[0].length; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
            ocean[r][c] = true;
            if(r-1>=0 && heights[r-1][c]>= heights[r][c] && !ocean[r-1][c]){
                dfs(r-1, c, ocean, heights);
            }
            if(r+1 <heights.length && heights[r+1][c]>= heights[r][c] && !ocean[r+1][c]){
                dfs(r+1, c, ocean, heights);
            }
            if(c-1>=0 && heights[r][c-1]>= heights[r][c] && !ocean[r][c-1]){
                dfs(r, c-1, ocean, heights);
            }
            if(c+1 <heights[0].length && heights[r][c+1]>= heights[r][c] && !ocean[r][c+1]){
                dfs(r, c+1, ocean, heights);
            }
    }
}
