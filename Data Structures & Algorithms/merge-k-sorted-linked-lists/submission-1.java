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
        if(lists == null || lists.length == 0){
            return null;
        } 
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r){
        if(l > r){
            return null;
        }

        if(l == r){
            return lists[r];
        }

        int mid = (l + r) / 2;

        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid + 1, r);

        return conquer(left, right);
    }

    private ListNode conquer(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if(left != null){
            current.next = left;
        }else{
            current.next = right;
        }

        return dummy.next;
    }
}
