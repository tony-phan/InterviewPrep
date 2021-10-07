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
    check all paths from root to a leaf and see if their sums add up to target
    
    Match
    Binary Search Tree
    DFS traversal
    
    Plan
    if the node we're at equals null return null
    if the node we're at is a leaf, check if the target minus its value is equal to 0
        return true
    recursively call the path sum method on the left and right children
    return true if either of them has a path sum
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        
        int remainingSum = targetSum - root.val;
        if(root.left == null && root.right == null && remainingSum == 0) {
            return true;
        }
        
        boolean hasLeftSum = hasPathSum(root.left, remainingSum);
        boolean hasRightSum = hasPathSum(root.right, remainingSum);
        
        return hasLeftSum || hasRightSum;
    }
}
