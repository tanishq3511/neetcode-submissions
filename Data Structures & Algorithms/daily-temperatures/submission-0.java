class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] numDays = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int x=0; x<temperatures.length; x++){
            while(!stack.isEmpty() && temperatures[x] > stack.peek()[0]){
                int[] top = stack.pop();
                numDays[top[1]] = x - top[1];
            }
            stack.push(new int[]{temperatures[x], x});
        }

        return numDays;
    }
}
