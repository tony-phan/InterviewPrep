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
    head = [1,2,3,4,5]
    output = [1,2,3,4,5]
    
    head = [1,1,1,2,2,2,3]
    output = [3]
    
    head = [1,2,2,2]
    
    head = [2,2,4,7,7]
    output = [4]
    
    Match
    Linked lists
    dummy head? Yes
    mutli pass? Probably not
    two pointers? Yes
    
    initialize a dummy head
    make 3 pointers: previous, left, right
    check if left.val == right.val
    if yes: keep moving right pointer until it's not equal to left.val or equal to null
            set prev.next = to right pointer
            set left pointer to where right pointer is
            right = left.next
    if no:  move previous, left, right down one pointer       
    
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode currentNode = dummyHead;
        while(currentNode.next != null && currentNode.next.next != null) {
            ListNode left = currentNode.next, right = currentNode.next.next;
            
            if(left.val == right.val) {
                while(left.val == right.val) {
                    if(right.next == null) {
                        right = null;
                        break;
                    }
                    else {
                        right = right.next;
                    }
                }
                currentNode.next = right;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        
        return dummyHead.next;
    }
}
