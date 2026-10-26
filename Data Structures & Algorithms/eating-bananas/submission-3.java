class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int p : piles){
            max = Math.max(max, p);
        }

        int min = 0;
        int res = max;

        while(min <= max){
            int mid = (max + min) / 2;
            int ctr = 0;
            for(int p : piles){
                ctr += Math.ceil(((double) p) / mid);
            }
            
            if(ctr <= h){
                res = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return res;
    }
}
