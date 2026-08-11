class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> streakSet = new HashSet<>();

        for(int x=0; x<nums.length; x++){
            streakSet.add(nums[x]);
        }
        int longest = 0;

        for(int x : streakSet){
            if(!streakSet.contains(x-1)){
                int length = 1;
                while(streakSet.contains(x+length)){
                    length++;
                }
                if(length>longest){
                    longest = length;
                }
            }
        }

        return longest;
    }
}
