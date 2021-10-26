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
    We are given two binary trees as input
    Return true if both trees are the same
    Two trees are the same if they have the same structure and all the nodes have the same value
    
    Match
    DFS traversal (pre order)
    
    Plan
    if tree1 and tree2 are equal to null return true
    if either tree1 is null and tree2 is not null OR tree1 is not null and tree2 is null, return false 
    if tree1 and tree2 values are not the same, return false
    recursively call isSameTree() on the left&right children of tree1 and tree2 (both recursive calls have to be true in order for both trees to be the same) 
    
    Evaluate
    Time: O(N)
    Space: O(N) // worst case if tree is unbalanced, O(logN) is tree is balanced
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q == null || p == null && q != null) {
            return false;
        }
        
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
