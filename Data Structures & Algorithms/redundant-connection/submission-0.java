class Solution {
    private boolean[] visit;
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        for(int x=0; x<=n; x++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        visit = new boolean[n+1];
        cycle = new HashSet<>();
        cycleStart = -1;
        dfs(1, -1);

        for(int x= edges.length-1; x>=0; x--){
            if(cycle.contains(edges[x][0]) && cycle.contains(edges[x][1])){
                return new int[]{edges[x][0], edges[x][1]};
            }
        }
        return new int[0]; 
    }

    private boolean dfs(int node, int par){
        if(visit[node]){
            cycleStart = node;
            return true;
        }

        visit[node] = true;
        for(int nei : adj.get(node)){
            if(nei == par){
                continue;
            }
            if(dfs(nei, node)){
                if(cycleStart != -1){
                    cycle.add(node);
                }
                if(node == cycleStart){
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
