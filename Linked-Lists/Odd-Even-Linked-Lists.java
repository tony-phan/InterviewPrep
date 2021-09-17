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
    1->2->3     1->3->2
    1           1
    
    Match
    Two pointers? No, having a fast & slow pointer would not help us
    Multiple pass? No, passing through the list multiple times wouldn't help
    Dummy head? Yes, we could use dummy head for holding the reference to the final list
    
    Plan
    Establish two dummy pointers for odd indices and even indices
    Loop through the list, for odd indices add to odd list, for even indices add to even list
    When done, join odd indices list with even list
    */
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        
        ListNode oddPointer = head, evenHead = head.next, evenPointer = evenHead;
        while(evenPointer != null && evenPointer.next != null) {
            oddPointer.next = evenPointer.next;
            oddPointer = oddPointer.next;
            evenPointer.next = oddPointer.next;
            evenPointer = evenPointer.next;
        }
        
        oddPointer.next = evenHead;
        return head;
    }
}
