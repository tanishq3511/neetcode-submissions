/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        HashSet<ListNode> seen = new HashSet<>();

        while(current != null ){
            if(seen.contains(current)){
                return true;
            }
            seen.add(current);
            current = current.next;
        }

        return false;
    }
}
