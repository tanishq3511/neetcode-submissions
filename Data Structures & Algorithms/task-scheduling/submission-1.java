class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        } 

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int ct : count){
            if(ct > 0){
                heap.add(ct);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            if(heap.isEmpty()){
                time = q.peek()[1];
            }else{
                int ct = heap.poll() - 1;
                if(ct > 0){
                    q.add(new int[]{ct, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
