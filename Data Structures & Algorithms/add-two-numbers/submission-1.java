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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int multiplier = 1;
        int total = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 != null){
                total += cur1.val*multiplier;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                total += cur2.val*multiplier;
                cur2 = cur2.next;
            }
            multiplier *= 10;
        }

        ListNode sumHead = new ListNode();
        ListNode cur = sumHead;
        if(total == 0){
            sumHead.val = 0;
            return sumHead;
        }
        while(total > 0){
            int mod = total % 10;
            ListNode node = new ListNode(mod);
            cur.next = node;
            cur = cur.next;
            total /= 10;
        }

        return sumHead.next;   
    }
}
