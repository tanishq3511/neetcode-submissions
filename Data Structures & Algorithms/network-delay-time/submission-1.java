class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time : times){
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int w1 = curr[0];
            int n1 = curr[1];
            if(visited.contains(n1)) continue;
            visited.add(n1);
            t = w1;

            if(edges.containsKey(n1)){
                for(int[] nei : edges.get(n1)){
                    int n2 = nei[0];
                    int w2 = nei[1];
                    if(!visited.contains(n2)) heap.offer(new int[]{t + w2, n2});
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
