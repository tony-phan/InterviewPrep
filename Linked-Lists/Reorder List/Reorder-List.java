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
Starting from the head of the list
use one pointer to keep a reference to remainder of list(current.next)
use another pointer to traverse down the list to get second to last node. the node after that is what we want to swap in front
do some pointer manipulation to swap the end node in the front
move the current pointer two nodes down
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode currentNode = head;
        while(currentNode.next != null && currentNode.next.next != null) {
            ListNode remainderOfList = currentNode.next;
            ListNode secondToLastNode = getSecondToLastNode(remainderOfList);
            ListNode lastNode = secondToLastNode.next;
            
            secondToLastNode.next = null;
            currentNode.next = lastNode;
            lastNode.next = remainderOfList;
            currentNode = currentNode.next.next;
        }
    }
    
    private ListNode getSecondToLastNode(ListNode node) {
        while(node.next.next != null) {
            node = node.next;
        }
        
        return node;
    }
}
