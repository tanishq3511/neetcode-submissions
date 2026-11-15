class Solution {

    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        if(!dfs(0, -1)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int i, int parent){
        if(visited.contains(i)) return false;

        visited.add(i);
        for(int nei : graph.get(i)){
            if(nei == parent) continue;

            if(!dfs(nei, i)){
                return false;
            }
        }
        return true;
    }
}
