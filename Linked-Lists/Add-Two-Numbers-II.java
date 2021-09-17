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
    l1=[9,9]
    l2=[1,0]
    output: [1,0,9]
    
    Since the most significant digit comes first, we cant just traverse to end of boths lists to begin the addition.
    We can use a stack to start at the least significant digit and began the addition
    
    Plan:
    Push nodes of l1 and l2 into two seperate stacks
    while both stacks are not empty, pop from the stack calculate the sum and carry
    create a new node of the sum & make that the new head of the solution list, keep track of carry
    repeat process until boths stacks are empty
    if carry is > 0, then create a new node with value of carry and make it the head of result list
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = null;
        
        Stack<ListNode> l1Stack = new Stack<>(), l2Stack = new Stack<>();
        ListNode l1Pointer = l1, l2Pointer = l2;
        
        while(l1Pointer != null) {
            l1Stack.push(l1Pointer);
            l1Pointer = l1Pointer.next;
        }
        while(l2Pointer != null) {
            l2Stack.push(l2Pointer);
            l2Pointer = l2Pointer.next;
        }
        
        int carry = 0;
        while(!l1Stack.empty() || !l2Stack.empty()) {
            int l1Val = l1Stack.empty() ? 0 : l1Stack.pop().val;
            int l2Val = l2Stack.empty() ? 0 : l2Stack.pop().val;
            
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int sumLSF = sum % 10;      // LSF: least significant figure
            
            ListNode node = new ListNode(sumLSF);
            node.next = solution;
            solution = node;
        }
        
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = solution;
            solution = node;
        }
        
        return solution;
    }
}
