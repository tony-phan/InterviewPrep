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
    Traverse through one of the lists,
    for each node, add their reference to a list
    traverse through the second list
    at each node, check if the list contains a reference to that node
    the first node that satisfies this condition is the intersection
    
    Evaluation
    Time: O(2n) -> O(n)
    traversing through list A and B once
    
    Space: O(n)
    storing all the elements of one list in an arraylist
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode solution = null;
        
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode headAPointer = headA;
        while(headAPointer != null) {
            list.add(headAPointer);
            headAPointer = headAPointer.next;
        }
        
        ListNode headBPointer = headB;
        while(headBPointer != null) {
            if(list.contains(headBPointer)) {
                solution = headBPointer;
                break;
            }
            headBPointer = headBPointer.next;
        }
        
        return solution;
    }
}
