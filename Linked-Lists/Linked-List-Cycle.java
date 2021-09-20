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
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slowPointer = dummyHead, fastPointer = dummyHead;
        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            
            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
