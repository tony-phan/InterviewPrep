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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    Understand
    We are given a sorted linked list in ascending order 
    Convert that linked list into a BST
    
    Match
    Linked List: use slow and fast pointer to get midpoint of list
    BST: construct tree similar to Leetcode problem #108 (convert sorted array to BST)
    
    Plan
    Use a fast & slow pointer to get the middle node in the linked list (middle node is the root)
    Create a new treenode with the middle nodes value
    Get the left and right half of the linked list (the left half will contain values for the left subtree and the right half will contain values for the right subtree)
    recursively call sortedListToBST() on the left half for root.left and sortedListToBST() on the right half for root.right 
    return root
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);        
        ListNode leftHalf = getLeftHalf(head, slow), rightHalf = slow.next;
        root.left = sortedListToBST(leftHalf);
        root.right = sortedListToBST(rightHalf);
        return root;
    }

    private ListNode getLeftHalf(ListNode head, ListNode stop) {
        if(head == null || head == stop) {
            return null;
        }
        ListNode node = head;
        while(node.next != stop) {
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
