class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int x= cost.length -3; x >=0; x--){
            cost[x] += Math.min(cost[x+1], cost[x+2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
