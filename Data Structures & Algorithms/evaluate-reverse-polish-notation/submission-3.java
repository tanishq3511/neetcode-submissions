class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for(String s : tokens){
           if(s.equals("+")){
            numStack.push(numStack.pop() + numStack.pop());
           }else if(s.equals("-")){
            int minus = numStack.pop();
            numStack.push(numStack.pop() - minus);
           }else if(s.equals("*")){
            numStack.push(numStack.pop() * numStack.pop());
           }else if(s.equals("/")){
            int bottom = numStack.pop();
            numStack.push(numStack.pop() / bottom);
           }else{
            numStack.push(Integer.parseInt(s));
           }
        }

        return numStack.pop();
    }
}
