class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int x = 0; x < temperatures.length; x++){
            int temp = temperatures[x];
            while(!stack.isEmpty() && temp > stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = x - pair[1];
            }
            stack.push(new int[]{temp, x});
        }

        return res;
    }
}
