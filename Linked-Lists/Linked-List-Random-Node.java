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
    
    Match
    Linked List problem
    
    Plan
    First we want to get the size of the list
    Loop through the list and keep track of the count
    Once we've reach the last node, set its next to the head so that we make the list a circular linked list
    
    for getRandom, generate a random number between 0 and the size of the list
    use a for loop to move the pointer the random number of times
    return the value at current node
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    Random random;
    ListNode pointer;
    int size = 1;
    public Solution(ListNode head) {
        random = new Random();
        pointer = head;
        while(pointer.next != null) {
            ++size;
            pointer = pointer.next;
        }
        pointer.next = head;
    }
    
    public int getRandom() {
        int r = random.nextInt(size);
        for(int i = 0; i < r; ++i) {
            pointer = pointer.next;
        }
        return pointer.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
