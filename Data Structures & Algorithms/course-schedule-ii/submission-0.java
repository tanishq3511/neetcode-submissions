class Solution {
    private List<Integer> output = new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> adj;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for(int x=0; x< numCourses; x++){
            adj.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        for(int x=0; x<numCourses; x++){
            if(indegree[x]==0){
                dfs(x);
            }
        }

        if(output.size()!= numCourses) return new int[0];
        int[] res = new int[output.size()];
        for(int x=0; x<output.size(); x++){
            res[x] = output.get(x);
        }

        return res;
    }

    private void dfs(int node){
        output.add(node);
        indegree[node]--;
        for(int nei : adj.get(node)){
            indegree[nei]--;
            if(indegree[nei]==0){
                dfs(nei);
            }
        }
    }
}
