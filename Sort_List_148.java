/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
有反应过来merge sort 但是不够自信啊。 fast/slow to divide into two 
*/
class Solution {
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
          return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) { //condition on fast being able to move forward
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }
    
        prev.next = null; // cut

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
      }  
  
      ListNode merge(ListNode l1, ListNode l2) {
            ListNode l = new ListNode(0), p = l;

            while (l1 != null && l2 != null) {
              if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
              } else {
                p.next = l2;
                l2 = l2.next;
              }
              p = p.next;
            }

            if (l1 != null) {
                p.next = l1;
            }
            if(l2!=null) {
                p.next = l2;
            }
//             while (l1 != null) {// difference at most one ? // because linkedlist!!! if more than one, will be added together
//                 p.next = l1;
//                 p = p.next;
//                 l1= l1.next;
//             }

//             while (l2 != null){
//                 p.next = l2;
//                 p = p.next;
//                 l2 = l2.next;
//             }

            return l.next;
      }

}
