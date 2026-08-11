class Solution {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;

        if(n == 1){
            return 1;
        }

        int step = 3;
        while(step <= n){
            int options = n1 + n2;
            n1 = n2;
            n2 = options;
            step++;
        }

        return n2;
    }
}
