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
    check for cases where # nodes is greater than, equal to, and less than k
    
    head = [1,2,3,4,5] k = 5
    output = [[1],[2],[3],[4],[5]]
    
    head = [1,2,3,4,5] k = 2
    output = [[1,2,3],[4,5]]
    
    head = [1,2,3,4,5] k = 7
    output = [[1],[2],[3],[4],[5],[],[]]
    
    Match
    linked list
    dummyHead? No
    two pointer? No
    multi pass? Yes we'll need to do one pass to get list size
    
    Plan
    Get list size
    Create an array to hold all the parts
        array size == k
    The size of each part == (list size / k), 
        the first N % k parts have a size == (size / k + 1)
    Loop through the list, assign a previous and current pointer to the linked list
        first determine the size of each "part" (call this x)
        move the pointer "x" nodes ahead
        add prev pointer to array, set prev to current.next, set current.next to null, set current = prev
        continue to end of linked list
        
    Better explanation: 
    */
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null) {
            return new ListNode[k];
        }
         
        ListNode[] solution = new ListNode[k];
        int listSize = getSize(head);
        
        ListNode pointer = head;
        for(int i = 0; i < solution.length; ++i) {
            int partSize = (i + 1) <= (listSize % k) ? (listSize / k) + 1 : (listSize / k);
            
            ListNode mover = pointer;
            for(int j = 0; j < partSize - 1; ++j) {
                if(mover.next != null) {
                    mover = mover.next;
                }
                else {
                    mover = null;
                    break;
                }
            }
            
            if(mover == null) {
                break;
            }
            ListNode remainderOfList = mover.next;
            solution[i] = pointer;
            mover.next = null;
            pointer = remainderOfList;
        }
        
        return solution;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        
        while(head != null) {
            ++size;
            head = head.next;
        }
        
        return size;
    }
}
