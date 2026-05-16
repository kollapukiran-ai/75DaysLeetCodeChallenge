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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // When a pointer reaches the end, redirect it to the other list's head.
        // If the lists intersect, the pointers will meet at the intersection node.
        // If not, both will eventually become null at the same time.
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;    
    }
}