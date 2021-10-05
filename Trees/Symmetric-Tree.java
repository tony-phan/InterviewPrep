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
    2       3       Not symmetric 
3         4
    
    Match
    Binary tree
    
    Plan
    We start at the root, compare the left and right children
    if the left and right children are null then it's symmetrical
    if the left is a node but the right is null OR is the left is null but the right is a node then its not symmetrical
    return if the vals of left & right are equal and check the mirrors for (left.left, right.right) AND (left.right, right.left)
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        
        return isMirror(root.left, root.right);
    }   
    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        
        if(left != null && right == null || left == null && right != null) {
            return false;
        }
        
        // in this case we know that left & right are both valid nodes and we want to compare their values and check the mirrors of their children
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
