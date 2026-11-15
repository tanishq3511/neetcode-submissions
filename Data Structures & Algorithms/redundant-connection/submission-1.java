class Solution {
    private HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);

            HashSet<Integer> visited = new HashSet<>();

            if(dfs(e[0], -1, visited)){
                return e;
            }
        }   
        return new int[0];
    }

    private boolean dfs(int i, int prev, HashSet<Integer> visited){
        if(visited.contains(i)) return true;

        visited.add(i);
        for(int nei : graph.get(i)){
            if(nei == prev) continue;

            if(dfs(nei, i, visited)) return true;
        }

        return false;
    }
}
