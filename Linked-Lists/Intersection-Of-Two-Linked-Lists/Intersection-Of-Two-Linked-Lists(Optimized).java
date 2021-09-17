/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    Understand 
    A = [1,2,3]
    B = []
    output: null
    
    A = [4,8,2,5,1]
    B = [5,4,1,6,2,5,1]
    
    Plan
    First get lengths of list A and B
    Calculate the difference and lengths
    Figure out which list is longer and move the pointer of that list ahead by length of the difference
    
    
    Evaluation
    Time: O(n)
    
    Space: O(1)
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode solution = null, headAPointer = headA, headBPointer = headB;
        int lengthA = length(headA), lengthB = length(headB);
        int difference = Math.abs(lengthA - lengthB);
        
        if(lengthA < lengthB) {
            for(int i = 0; i < difference; ++i) {
                headBPointer = headBPointer.next;
            }
        }
        if(lengthB < lengthA) {
            for(int i = 0; i < difference; ++i) {
                headAPointer = headAPointer.next;
            }
        }
        
        while(headAPointer != null || headBPointer != null) {
            if(headAPointer == headBPointer) {
                solution = headAPointer;
                break;
            }
            
            headAPointer = headAPointer.next;
            headBPointer = headBPointer.next;
        }
        
        
        return solution;
    }
    private int length(ListNode head) {
        int length = 0;
        while(head != null) {
            ++length;
            head = head.next;
        }
        
        return length;
    }
}
