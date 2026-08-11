class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int x=0; x<numCourses; x++){
            preMap.put(x, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int x=0; x<numCourses; x++){
            if(!dfs(x)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int x){
        if(visiting.contains(x)){
            return false;
        }

        if(preMap.get(x).isEmpty()){
            return true;
        }

        visiting.add(x);
        for(int pre : preMap.get(x)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(x);
        preMap.put(x, new ArrayList<>());
        return true;
    }
}
