class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }

        int l = 1;
        int r = maxPile;
        int k = r;
        while(l <= r){
            int mid = (l + r) / 2;
            int time = 0;
            for(int pile : piles){
                time += pile / mid;
                if(pile % mid != 0) time++;
            }

            if(time > h){
                l = mid + 1;
            }else{
                k = mid;
                r = mid - 1;
            }
        }

        return k;
    }
}
