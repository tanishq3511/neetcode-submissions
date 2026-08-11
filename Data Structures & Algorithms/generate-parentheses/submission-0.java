class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String stack = "";
        findValid(0, 0, n, res, stack);
        return res;
    }

    private void findValid(int numOpen, int numClose, int n, List<String> res, String stack){
        if(numOpen == numClose && numOpen == n){
            res.add(stack);
            return;
        }

        if(numOpen<n){
            stack += "(";
            findValid(numOpen + 1, numClose, n, res, stack);
            stack = stack.substring(0, stack.length()-1);
        } 
        if(numClose < numOpen){
            stack += ")";
            findValid(numOpen, numClose+1, n, res, stack);
            stack = stack.substring(0, stack.length()-1);
        }
    }
}
