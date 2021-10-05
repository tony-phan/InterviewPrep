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
            1
        2       3    false
      4   5   6   
             7
    
    Match
    Binary Search Tree
    
    Plan
    if the root is null return true
    for the current node we're at, get the height of its left & right child
    if the difference of them is greater than 1, return false
    recursively call isBalanced on the left and right child and return them
    
    to calculate the height of a node:
    if the node is null return 0
    recursively call the getHeight on the left and right children
    return 1 + the max of left and right heights
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        return 1 + Math.max(left, right);
    }
}
