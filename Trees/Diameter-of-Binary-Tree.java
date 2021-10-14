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
    
    Plan
    Binary Tree
    DFS traversal
    
    Match
    starting from the root node
    get the height of the left subtree (maxEdges)
    get the height of the right subtree (maxEdges)
    sum them and compare to the current diameter (store the max of them)
    
    recursively call diameterOfBinaryTree() on left and right children because the longest path between any two nodes may not pass through the root
    
    return the diameter at the end
    
    Evaluate
    Time: O(H*log(N)
    Space: O(H*log(N))
    */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int diameter = 0;
        int maxLeftHeight = root.left == null ? 0 : getHeight(root.left);
        int maxRightHeight = root.right == null ? 0 : getHeight(root.right);
        diameter = Math.max(diameter, maxLeftHeight + maxRightHeight);
        
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        
        return diameter;
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
