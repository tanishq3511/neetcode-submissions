class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int stone : stones){
            heap.offer(stone * -1);
        }

        while(heap.size() > 1){
            int stone1 = heap.poll() * -1;
            int stone2 = heap.poll() * -1;

            if(stone1 > stone2){
                heap.offer((stone1 - stone2) * -1);
            }
        }

        if(heap.size() == 0){
            return 0;
        }

        return (heap.poll() * -1);
    }
}
