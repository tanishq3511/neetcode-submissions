class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile, max);
        }
        
        int min = 1;
        int res = max;
        while(min <= max){
            int mid = (max + min) / 2;
            int ctr = 0;
            for(int pile : piles){
                ctr += Math.ceil(((double) pile) / mid);
            }

            if(ctr <= h){
                res = Math.min(res, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return res;
    }
}
