/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/** method 0: use extra space, trivial (set)
* method 1: change the structure of the list node, convert to from back to start
* method 2: linear time and constant space, traverse list a and b count the length 
and keep record of the tails. if tails different null. tails same, move ptr for the 
longer list for difference times, and move the ptrs together until the same node. <---- important : follow up 
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tailA = null, tailB = null;
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
            tailA = ptrA;
        }
        
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
            tailB = ptrB;
        }
        
        if (tailA != tailB) return null;
        ptrA = headA;
        ptrB = headB;
        while (lenA > lenB) {
            ptrA = ptrA.next;
            lenA--;
        }
        while (lenB > lenA) {
            ptrB = ptrB.next;
            lenB--;
        }
        
        while (ptrA!=ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return ptrB;
    }
}
