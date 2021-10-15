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
    given two binary trees, we want to merge them by adding the values of the nodes that overlap
    Example:    tree1         tree2
                 1               4
               2               5   3
                   tree1 + tree2 
                         5
                       7   3
    Match
    Binary trees
    DFS traversal
    
    Plan
    do a dfs (pre order) traversal through either one of the trees
    before adding values of the nodes check for 3 cases: both trees are empty, only tree1 is empty, and only tree2 is empty
    if all three cases are passed, add the nodes values and recursively call the merheTrees method on the left and right subtrees
    return tree1
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        if(root1 == null && root2 != null) {
            return root2;
        }
        if(root1 != null && root2 == null) {
            return root1;
        }
        
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}
