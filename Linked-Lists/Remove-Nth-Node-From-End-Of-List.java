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
    1->2->3->4->5, n=5
    2->3->4->5
    
    1->2->3, n=2
    1->3
    
    Match
    Linked-List
    Two-pointer? Yes, use two pointers to help remove n'th node from list
    Multiple pass? Yes can be used to get size of list
    Dummy head? Yes can be used to keep reference of list since we are manipulating it
    
    Plan
    separate two nodes by n nodes, once right pointer reaches end of the list, the left pointer's next node is the one you want to delete. To make it easy deleting head of the list, use a dummy pointer
    
    Implement
    
    Review
    
    Evaluate
    Time: O(n)
    Space: O(1)
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode left = dummy, right = dummy;
        for(int i = 0; i < n; ++i) {
            right = right.next;
        }
        
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        
        return dummy.next;
    }
}
