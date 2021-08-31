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
    1->0->1     0->1        1->1->1
    101         10          111
    
    0->9        0->2        0->1->1
    90          20          110
    
    Match
    Linked Lists
    Two pointer? No, a fast and slow pointer would not help
    Multiple pass? No, we do not need to make multiple passes through the lists
    Dummy head? Since we are creating a new list, a dummy head can hold that reference
    
    Plan
    Use one pointer to traverse l1 and another pointer to traverse l2
    For each "place" we're at get sum of current value of l1 and l2
    calculate carry and tens place value
    create a new node with value of the tens place of sum
    keep value of carry
    repeat process until we have reached end of l1 and l2
    at end, if carry is > 0, then create a new node with carry value and include that in the sum list
    
    Implement
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode l1Pointer = l1, l2Pointer = l2, current = dummyHead;
        
        int carry = 0;
        while(l1Pointer != null || l2Pointer != null) {
            int l1Val = (l1Pointer != null) ? l1Pointer.val : 0;
            int l2Val = (l2Pointer != null) ? l2Pointer.val : 0;
            
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if(l1Pointer != null) {
                l1Pointer = l1Pointer.next;
            }
            if(l2Pointer != null) {
                l2Pointer = l2Pointer.next;
            }
        }
        
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}
