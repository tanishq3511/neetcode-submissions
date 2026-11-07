class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while(r < n){
            //while new element added to window is greater, pop off older ones to keep decreasing structure
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            //add new element
            q.addLast(r);

            //if max is now out of the window, pop it off
            if(l > q.getFirst()){
                q.removeFirst();
            }

            //put into our output array
            if(r + 1 >= k){
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}
