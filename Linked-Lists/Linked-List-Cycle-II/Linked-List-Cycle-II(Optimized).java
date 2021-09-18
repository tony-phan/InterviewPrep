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
    use a fast & slow pointer to find if there is a cycle in the list
    if no cycle return null
    if yes, use the slow or fast pointer to get the size of the cycle
    create 2 more pointers, move one of the pointers down the list n times (n = size of the cycle)
    move both pointers one at a time until they equal
    return the node they are equal at
    
    Evaluate
    Time: O(n)
    Space: O(1)
    */
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode solution = null, slowPointer = head, fastPointer = head;
        int cycleSize = 0;
        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            
            if(slowPointer == fastPointer) {
                cycleSize = getCycleSize(slowPointer);
                break;
            }
        }
        
        if(cycleSize > 0) {
            ListNode pointer1 = head, pointer2 = head;
            for(int i = 0; i < cycleSize; ++i) {
                pointer2 = pointer2.next;
            }
            // The main intuition is that pointer1 and pointer2 should be exactly n nodes away from the start of the cycle, so we can use that information to figure out which node is the start of the cycle
            while(pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            
            solution = pointer1;
        }
        return solution;
    }
    
    private int getCycleSize(ListNode cycleIntersection) {
        int size = 0;
        ListNode pointer = cycleIntersection;
        while(true) {
            ++size;
            pointer = pointer.next;
            
            if(pointer == cycleIntersection) {
                break;
            }
        }
        return size;
    }
}
