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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next; //first node right of k group
            ListNode prev = kth.next; //prev
            ListNode curr = groupPrev.next; //first node in group

            //reversing the k group
            while(curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            //attaching the group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
