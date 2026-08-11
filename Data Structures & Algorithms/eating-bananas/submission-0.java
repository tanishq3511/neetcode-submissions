class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int i : piles){
            if(i>maxPile){
                maxPile = i;
            }
        }

        int optimalEat = maxPile;

        int low = 1;
        while(low<=maxPile){
            int mid = (low+maxPile)/2;

            int time = 0;
            for(int i : piles){
                time += Math.ceil((double) i/mid);
            }
            if(time<=h){
                optimalEat = mid;
                maxPile = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return optimalEat;
    }
}
