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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode current = head;
        while(!allListsNull(lists)){
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            for(int x=0; x< lists.length; x++){
                if(lists[x]!= null && lists[x].val < minVal){
                    minVal = lists[x].val;
                    minIndex = x;
                }
            }
            lists[minIndex] = lists[minIndex].next;
            current.next = new ListNode(minVal);
            current = current.next;
        }

        return head.next;
    }

    public boolean allListsNull(ListNode[] lists){
        for(int x=0; x<lists.length; x++){
            if(lists[x] != null){
                return false;
            }
        }
        return true;
    }
}
