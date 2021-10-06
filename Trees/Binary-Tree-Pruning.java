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
    
    Match
    Binary Tree
    DFS search 
    
    Plan
    do a post order traversal
    for each node we're at we want to check that the left and right nodes contain a 1 in their subtrees
        if they do not set them to null
    return the root
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        root.left = !contains1(root.left) ? null : pruneTree(root.left);
        root.right = !contains1(root.right) ? null : pruneTree(root.right);
        
        // edge case where we have a node with value of 0 and the left&right children do not contain a 1
        if(root.left == null && root.right == null && root.val != 1) {
            return null;
        }
        
        return root;
    }
    
    private boolean contains1(TreeNode node) {
        if(node == null) {
            return false;
        }
        
        if(node.val == 1) {
            return true;
        }
        return contains1(node.left) || contains1(node.right);
    }
}
