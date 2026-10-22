class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                int sub = stack.pop();
                stack.push(stack.pop() - sub);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                int deno = stack.pop();
                stack.push(stack.pop() / deno);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
