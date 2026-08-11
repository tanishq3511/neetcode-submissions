class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        // Map<Character, Character> pairs = new HashMap<>();
        // pairs.put(')', '(');
        // pairs.put('}', '{');
        // pairs.put(']', '[');

        // for(char c : s.toCharArray()){
        //     if(pairs.containsKey(c)){
        //         if(!myStack.isEmpty() && myStack.peek() == pairs.get(c)){
        //             myStack.pop();
        //         }else{
        //             return false;
        //         }
        //     }else{
        //         myStack.push(c);
        //     }
        // }
        for(char c : s.toCharArray()){
            if(c==')'){
                if(!myStack.isEmpty() && myStack.peek()=='('){
                    myStack.pop();
                }else{
                    return false;
                }
            }else if(c=='}'){
                if(!myStack.isEmpty() && myStack.peek()=='{'){
                    myStack.pop();
                }else{
                    return false;
                }
            }else if(!myStack.isEmpty() && c==']'){
                if(myStack.peek()=='['){
                    myStack.pop();
                }else{
                    return false;
                }
            }else{
                myStack.push(c);
            }
        }
        return myStack.isEmpty();
    }
}
