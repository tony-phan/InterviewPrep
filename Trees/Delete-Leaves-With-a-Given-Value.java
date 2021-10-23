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
    We are given a binary tree and a target val as input
    We want to remove all leaf nodes in the tree whose value is equal to target
    Important: if a leaf node with value target is deleted, if its parent node becomes a leaf and has the value target, then we want to delete that node as well
    
    Match
    Binary tree
    DFS traversal
    
    Plan
    Do a dfs traversal on the tree
    For the current node we're at, if it's equal to null or if its a leaf node and has value of target return null
    recursively call removeLeafNodes on the left and right children
    while we still have a leaf node with value target in the tree, recursively call removeLeafNodes on the current node
    return root
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null || isLeaf(root) && root.val == target) {
            return null;
        }
        
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        while(containsLeafTarget(root, target)) {
            root = removeLeafNodes(root, target);
        }
            
        return root;
    }
    private boolean isLeaf(TreeNode node) {
        if(node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
    
    private boolean containsLeafTarget(TreeNode root, int target) {
        if(root == null) {
            return false;
        }    
        
        if(root.val == target && isLeaf(root)) {
            return true;
        }
        return containsLeafTarget(root.left, target) || containsLeafTarget(root.right, target);
    }
}
