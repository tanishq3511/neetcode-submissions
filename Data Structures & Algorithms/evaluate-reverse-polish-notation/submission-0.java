class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num1+num2);
            }else if(s.equals("-")){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num2-num1);
            }else if(s.equals("*")){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num1*num2);
            }else if(s.equals("/")){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num2/num1);
            }else{
                int num = Integer.parseInt(s);
                numStack.push(num);
            }
        }
        return numStack.peek();
    }
}
