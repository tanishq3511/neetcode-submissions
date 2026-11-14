/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> toClone;
    public Node cloneGraph(Node node) {
        toClone = new HashMap<>();

        return dfs(node);
    }

    private Node dfs(Node node){
       if(node == null) return null;

       if(toClone.containsKey(node)){
        return toClone.get(node);
       }
       Node clone = new Node(node.val);
       toClone.put(node, clone);
       for(Node n : node.neighbors){
        clone.neighbors.add(dfs(n));
       }

       return clone;
    }
}