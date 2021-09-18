/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /*
    1->2->3->4->5->6, pos = 3
    1   pos = 0
    
    Match
    Linked list
    
    Plan
    Traverse the list
    for each node we're at, check if the set contains that node
    if yes, return that node
    if no, add the node to the set and continue down the list
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode solution = null, pointer = head;
        Set<ListNode> set = new HashSet<>();
        while(pointer != null) {
            if(set.contains(pointer)) {
                solution = pointer;
                break;
            }
            
            set.add(pointer);
            pointer = pointer.next;
        }
        
        return solution;
    }
}
