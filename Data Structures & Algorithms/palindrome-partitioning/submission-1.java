class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> parts = new ArrayList<>();
        dfs(0, s, parts);
        return res;
    }

    private void dfs(int i, String s, List<String> parts){
        if(i>=s.length()){
            res.add(new ArrayList<>(parts));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                parts.add(s.substring(i, j+1));
                dfs(j+1, s, parts);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
