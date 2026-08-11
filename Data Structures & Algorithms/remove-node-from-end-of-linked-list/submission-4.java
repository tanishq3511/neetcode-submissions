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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }

        int beforeDel = length - n;
        if(beforeDel == 0){
            return head.next;
        }
        current = head;
        for (int x = 0; x < length - 1; x++) {
            if ((x + 1) == beforeDel) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
}
