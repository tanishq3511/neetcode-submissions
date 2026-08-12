class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int x = 0; x < s.length(); x++){
            char c = s.charAt(x);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty() || map.get(c) != stack.pop()){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
