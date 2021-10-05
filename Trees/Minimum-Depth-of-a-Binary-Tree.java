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
        1       output: 1
        
        2
          3
            4       output = 5
              5
                6
    Match
    Binary Search Tree
    
    Plan
    if the node is null then the mindepth is 0
    
    if the node only has a left child
        then get the mindepth of its left child and add to the running sum
    if the node only has a right child
        then get the mindepth of its right child and add to the running sum
    if the node has a left & right child
        get the minimum of the left and right child mindepths and add to the running sum
    return the running sum
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int result = 1;
        if(root.left == null && root.right != null) {
            result += minDepth(root.right);
        }
        else if(root.left != null && root.right == null) {
            result += minDepth(root.left);
        }
        else {
            result += Math.min(minDepth(root.right), minDepth(root.left));
        }
        
        return result;
    }
}
