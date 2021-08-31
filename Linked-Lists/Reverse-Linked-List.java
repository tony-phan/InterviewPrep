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
    1->2->3     ->      3->2->1
    1           ->      1 (edge case)
    1->2        ->      2->1
    
    
    Match
    Linked-Lists
    Two pointer? No, a fast and slow pointer will not help
    Dummy head? Yes, it can hold the reference to the reversed list
    Multiple pass? No, multiple passes through the list is not necessary
    
    Plan
    establish a dummy head to hold reversed list
    traverse through the list, for current node, make it the new head of reversed list
    keep a pointer for reference to remainder of original list
    keep doing this until end of list
    
    Implement
    
    Review
    
    Evaluate
    Time: O(n), one pass through the list
    Space: O(1)
    */
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        
        ListNode reversed = null;
        while(head.next != null) {
            ListNode remainingList = head.next;
            head.next = reversed;
            reversed = head;
            head = remainingList;
        }
        head.next = reversed;
        reversed = head;
        
        return reversed;
    }
}
