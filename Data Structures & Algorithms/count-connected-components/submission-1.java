class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int numComponents = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                numComponents++;
                dfs(i, -1);
            }
        }

        return numComponents;
    }

    private void dfs(int i, int prev){
        if(visited.contains(i)) return;

        visited.add(i);
        for(int nei : graph.get(i)){
            if(nei == prev) continue;
            dfs(nei, i);
        }
    }
}
