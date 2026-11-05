/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node current = head;
        while(current != null){
            oldToCopy.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while(current != null){
            oldToCopy.get(current).next = oldToCopy.get(current.next);
            oldToCopy.get(current).random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }
}
