class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : set){
            if(set.contains(num-1)) continue;

            int streak = 1;

            while(set.contains(num + streak)) streak++;

            if(streak > longest) longest = streak;
        }

        return longest;
    }
}
