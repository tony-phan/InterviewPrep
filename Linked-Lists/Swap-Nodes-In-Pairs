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
    1,2,3,4,5 -> 2,1,4,3,5
    1,2,3 -> 2,1,3
    
    Match
    Linked-List
    
    Plan
    Multiple Pass? No, since we aren’t collecting unique items or need any pre-processing.
    Dummy Head? Yes, since we have to manipulate the order of the list, including the head of the list (a dummy head would help maintain a pointer to beginning of the list)
    Two Pointer? No, a slow and fast pointer may not help the problem.
    
    Implement
    Create a dummy node that points to the first node
    Create another node that will first point to the dummy node and will be used to keep track of the current node as we loop through the list
    Iterate through the list while we have TWO valid nodes ahead
    Swap the two heads ahead of the pointer
    Update the current node to point to the second post-swap node
    Continue to iterate until end of list
    
    Review
    Verify the code works with the happy cases created in the “Understand” section.
    Use the code for the edge cases created in the “Plan” section.

    Evaluate
    Time: O(n)
    Single pass through the LinkedList

    Space: O(1)
    Only 1 dummy node created for any size list
    */
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode currentNode = dummy;
        while(currentNode.next != null && currentNode.next.next != null) {
            ListNode first = currentNode.next;
            ListNode second = currentNode.next.next;
            
            first.next = second.next;
            second.next = first;
            
            currentNode.next = second;
            currentNode = first;
        }
        
        return dummy.next;
    }
}
