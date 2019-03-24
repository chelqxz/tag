/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // recursive !!! you did it!!!
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode first = head;
        ListNode second = head.next;
        ListNode dummyhead = new ListNode(-1);
        ListNode prev = dummyhead;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = first;
            // first.next = null; // cut extra edge
            prev.next = second;
            prev = first;
            first = tmp;
            second = (tmp == null) ? null: tmp.next;
        }
        if (first == null && second == null) {
            prev.next = null;
        } else {
            prev.next = first;
        }
            
        
        return dummyhead.next;
    }
}


 // recursive
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode first = head;
        ListNode second = head.next;
        ListNode next = swapPairs(head.next.next);
        second.next = first;
        first.next = next;
        return second;
    }
}
