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
    Algorithm: 
    Use a dummy head to hold reference to solution list
    Use a pointer to traverse both l1 and l2
    Compare values of current val at l1 and l2
    add the smaller value to solution list
    Update l1, l2, and dummy pointer accordingly
    Repeat this until either l1 or l2 pointer has reached null
    check if either l1 or l2 has remaining values not added yet
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1 == null && l2 != null) {
            return l2;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode dummyPointer = dummy, l1Pointer = l1, l2Pointer = l2;
        
        while(l1Pointer != null && l2Pointer != null) {
            int l1Val = l1Pointer.val;
            int l2Val = l2Pointer.val;
            
            if(l1Val < l2Val) {
                dummyPointer.next = l1Pointer;
                l1Pointer = l1Pointer.next;
                dummyPointer = dummyPointer.next;
                dummyPointer.next = null;
            }
            else if(l2Val < l1Val) {
                dummyPointer.next = l2Pointer;
                l2Pointer = l2Pointer.next;
                dummyPointer = dummyPointer.next;
                dummyPointer.next = null;
            }
            else {
                dummyPointer.next = l1Pointer;
                l1Pointer = l1Pointer.next;
                dummyPointer = dummyPointer.next;
                dummyPointer.next = l2Pointer;
                l2Pointer = l2Pointer.next;
                dummyPointer = dummyPointer.next;
                dummyPointer.next = null;
            }
        }
        
        if(l1Pointer != null) {
            dummyPointer.next = l1Pointer;
        }
        
        if(l2Pointer != null) {
            dummyPointer.next = l2Pointer;
        }
        
        
        return dummy.next;
    }
}
