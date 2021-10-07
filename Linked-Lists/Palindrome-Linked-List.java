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
    Match
    Linked list
    Dummy head? Yes
    Multipass? Not needed
    Two pointer? Yes slow and fast pointer will need to be used
    
    Plan
    Use a slow and fast pointer to locate the second half of the list
    If the linked list is a palindrome, then the first half of the list shuold be the same as the reverse of the second half
    Reverse the second half of the list and compare its values with the first half
    
    Evaluate
    Time: O(n)
    Space: O(1)
    */
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        if(head.next == null) {
            return true;
        }
        
        boolean result = true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstHalf = head, secondHalf = null;
        if(fast.next == null) {
            secondHalf = slow.next;
            slow = null;
        }
        else {
            secondHalf = slow.next;
            slow.next = null;
        }
        
        ListNode reversedSecondHalf = reverse(secondHalf);
        
        ListNode firstHalfPointer = head, secondHalfPointer = reversedSecondHalf;
        while(firstHalfPointer != null && secondHalfPointer != null) {
            if(firstHalfPointer.val != secondHalfPointer.val) {
                result = false;
                break;
            }
            
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
    
        return result;
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null) {
            return null;
        }
        
        ListNode result = null, pointer = node;
        while(pointer != null) {
            ListNode remainingNodes = pointer.next;
            pointer.next = result;
            result = pointer;
            pointer = remainingNodes;
        }
        
        return result;
    }
}
