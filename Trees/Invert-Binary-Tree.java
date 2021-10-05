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
    Match
    Binary Tree
    
    Plan
    Since we want to process data at the node first before going to the children, we want to do a preorder traversal 
    First invert the children of the node we're at right now
    then recursively call the invertTree method on the left and right children and set then as the new children
    return the root
    
    Evaluate
    Time: O(n) since we visit all nodes in the tree
    Space: O(h) where h is the height of the tree
    */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        invert(root);
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        return root;
    }
    
    private void invert(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
