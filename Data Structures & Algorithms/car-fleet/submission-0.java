class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int x=0; x<position.length; x++){
            pair[x][0] = position[x];
            pair[x][1] = speed[x];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int[] p : pair){
            if(!stack.isEmpty()){
                double top = stack.peek();
                stack.push((double) (target-p[0]) / p[1]); // (target-pos)/time
                if(stack.peek()<=top){
                    stack.pop();
                }
            }else{
                stack.push((double) (target-p[0]) / p[1]); // (target-pos)/time
            }
        }
        return stack.size();
    }
}
