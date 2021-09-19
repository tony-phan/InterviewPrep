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

/*
Understand
head = [2,3,7,1,9]
output = [2,9,3,1,7]

head = [1,3,5,9]
output = [1,9,3,5]

head = [1,2]
output = [1,2]

Match
linked list
dummy head? probably not needed since we are not manipulating the head node
multi pass? Probably not since one pass thru the list seems fine
two pointer? Yes, we're gonna need multiple pointers to hold reference of remaining list, pointer for node to swap in, and maybe previous

Plan
split the list in half
reverse the second half of the list
create the reordered list by merging both lists together (grab 1 node from first half and then grab 1 node from the second half)
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode dummyHead = new ListNode(-1), slowPointer = head, fastPointer = head;
        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        ListNode secondHalf = slowPointer.next;
        slowPointer.next = null;
        ListNode reversedSecondHalf = reverse(secondHalf);
        
        ListNode firstHalf = head, dummyPointer = dummyHead;
        while(firstHalf != null && reversedSecondHalf != null) {
            dummyPointer.next = firstHalf;
            firstHalf = firstHalf.next;
            dummyPointer.next.next = reversedSecondHalf;
            reversedSecondHalf = reversedSecondHalf.next;
            dummyPointer = dummyPointer.next.next;
            dummyPointer.next = null;
        }
        
        if(firstHalf != null) {
            dummyPointer.next = firstHalf;
        }
        if(reversedSecondHalf != null) {
            dummyPointer.next = reversedSecondHalf;
        }
        
        head = dummyHead.next;
    }
    private ListNode reverse(ListNode list) {
        ListNode reversed = null;
        
        ListNode listPointer = list;
        while(listPointer != null) {
            ListNode remainingList = listPointer.next;
            listPointer.next = reversed;
            reversed = listPointer;
            listPointer = remainingList;
        }
        
        return reversed;
    }
}
