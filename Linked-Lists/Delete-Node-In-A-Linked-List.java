/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Understand
    4->5->1->9, node = 4      5->1->9
    4->5->1->9, node = 1      4->5->9
    
    Match
    Linked-List
    Two pointer? No a slow and fast pointer will not help
    Dummy Head? Yes, use a dummy pointer to help with swapping
    Multiple pass? We only need to do one pass through the list
    
    Plan
    Establish a dummy pointer to the right of the given node (rightPointer)
    Swap values of node to delete (leftPointer) and dummy pointer (rightPointer) until dummy pointer is at end of list
    Do one last swap to move value to delete to end of list
    Set leftPointer to point to null to delete node
    
    Implement
    
    Review
    
    Evaluate
    Time: O(n)
    Space: O(1)
    
    */
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        
        ListNode dummy = node.next;
        while(dummy.next != null) {
            swap(node, dummy);
            
            node = node.next;
            dummy = dummy.next;
        }
        
        swap(node, dummy);
        node.next = null;
    }
    private void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
