class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int x = 0; x < temperatures.length; x++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[x]){
                int[] pair = stack.pop();
                res[pair[1]] = x - pair[1];
            }
            stack.push(new int[]{temperatures[x], x});
        }

        return res;
    }
}
