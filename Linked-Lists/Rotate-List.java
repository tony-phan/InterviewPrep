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
    
    /*
    Understand
    1, k=3 [edge case]
    1
    
    1->2->5, k=3
    1->2->5
    
    1->2->5, k=6   (Probably want to do some kind of modolus to get net number of rotations)
    1->2->5
    
    2->3, k = 3
    3->2
    
    Match
    Linked List
    
    Plan
    Multiple Pass? Yes, would be helpful to get length of list for calculating net rotations
    Dummy Head? Yes, since we have to manipulate the order of the list, including the head of the list
    Two Pointer? No, a slow and fast pointer may not help the problem.  
    
    Implement
    Do one-pass through the list to get list length and use that to calculate net rotations
    Performing the rotation: 
    - Iterate through the list until you get to second to last node
    - create dummy pointer to point to last node, update dummy's next node to point to head
    - Update head to point to dummy node
    - Update second to last node to point to null
    - Do this (length % k) times!
    
    Review
    Verify the code works with the happy cases created in the “Understand” section.
    Use the code for the edge cases created in the “Plan” section.

    Evaluate
    Time: O(n * k)
    Performed multiple passes through list
    Space: O(1)
    Only multiple dummy nodes created 
    */
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }
        
        // do one-pass thru list to get length
        ListNode dummy = head;
        int size = 0;
        while(dummy != null) {
            ++size;
            dummy = dummy.next;
        }
        
        int netRotations = k % size;
        for(int i = 0; i < netRotations; ++i) {
            dummy = head;
            while(dummy.next.next != null) {
                dummy = dummy.next;
            }
            ListNode last = dummy.next;
            dummy.next = null;
            last.next = head;
            head = last;
        }
        return head;
    }
}
