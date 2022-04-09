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
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.
    Example: Input: head = [1,4,3,2,5,2], x = 3
             Output: [1,2,2,4,3,5]
    
    Match
    Linked list
    
    Plan
    the basic idea is to maintain two list, the first one stores all nodes with val less than x , and the second list stores all the rest nodes. Then concat these two lists
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode leftHalf = new ListNode(-1), rightHalf = new ListNode(-1);
        
        ListNode pointer = head, leftHalfPointer = leftHalf, rightHalfPointer = rightHalf;
        while(pointer != null) {
            if(pointer.val < x) {
                leftHalfPointer.next = pointer;
                leftHalfPointer = leftHalfPointer.next;
                pointer = pointer.next;
                leftHalfPointer.next = null;
            }
            else {
                rightHalfPointer.next = pointer;
                rightHalfPointer = rightHalfPointer.next;
                pointer = pointer.next;
                rightHalfPointer.next = null;
            }
        }
        
        leftHalfPointer.next = rightHalf.next;
        dummyHead.next = leftHalf.next;
        
        return dummyHead.next;
    }
}

/*

x = 3
2
p
leftHalf: -1 -> 1 -> 2 -> 2
                          |
                          V
rightHalf:          -1 -> 4 -> 3 -> 5
*/
