public class WordNode {
    HashMap<Character, WordNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {

    WordNode root;

    public WordDictionary() {
        root = new WordNode();
    }

    public void addWord(String word) {
        WordNode cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new WordNode());
            cur = cur.children.get(c);
        }

        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, WordNode root){
        if(idx == word.length()){
            return root.endOfWord;
        }
        char c = word.charAt(idx);
        if(c=='.'){
            for(char key : root.children.keySet()){
                if(dfs(word, idx+1, root.children.get(key))){
                    return true;
                }
            }
            return false;
        }else{
            if(!root.children.containsKey(c)){
                return false;
            }
        }
        return dfs(word, idx+1, root.children.get(c));
    }
}
