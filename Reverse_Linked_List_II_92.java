/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode prev = null, cur = head;
        int i = 1;
        for (; i < m; i++) { //while (m > 1) { m--; n--;
            prev = cur;
            cur = cur.next;
        } // out i == m
        ListNode tail = cur, con = prev; // con can be null
        ListNode tmp = null;
        
        for (; i <= n; i++) { //while (n > 0) { n--
            tmp = cur.next; // not prev.next = cur.next just use an tmp to represent cur.next
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        if (con != null) {
            con.next = prev;
        }else {
            head = prev; // complete reverse
        }
        tail.next = cur;
        return head;
    }
}
