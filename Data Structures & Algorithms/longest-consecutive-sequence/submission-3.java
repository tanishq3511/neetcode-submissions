class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int x : nums){
            set.add(x);
        }

        int res = 0;

        for(int x : nums){
            if(set.contains(x-1)) continue;

            int streak = 1;
            int y = x + 1;
            while(set.contains(y)){
                streak++;
                y++;
            }

            if(streak > res) res = streak;
        }

        return res;
    }
}
