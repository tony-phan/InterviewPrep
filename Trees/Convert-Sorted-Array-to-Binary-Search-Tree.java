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
    Edge case: null - null
    
    Match
    BST
    In order traversal will return all nodes in ascending order
    
    Plan
    The midpoint of the array will be the root
    the midpoint of the array's left half will be the root's left
    the midpoint of the array's right half will be the root's right
    we want to recursively call this on root's left & root's right
                     
    TreeNode
    
    left = start of nums
    right = nums size
    get midpoint
    root = nums[midpoint]
        
    root.left = helper(left, updated right, nums)  // always check left < right
    root.right = helper(updated left, right, nums)
    
    return root
    
    Implement
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        int left = 0, right = nums.length - 1;
        int midpoint = (left + right)/2;
        TreeNode root = new TreeNode(nums[midpoint]);
        root.left = getSubtreeRoot(left, midpoint - 1, root, nums);
        root.right = getSubtreeRoot(midpoint + 1, right, root, nums);
        
        return root;
    }
    
    private TreeNode getSubtreeRoot(int left, int right, TreeNode root, int[] nums) {
        if(left > right) {
            return null;
        }
        
        int midpoint = (left + right)/2;
        TreeNode newNode = new TreeNode(nums[midpoint]);
        newNode.left = getSubtreeRoot(left, midpoint - 1, root, nums);
        newNode.right = getSubtreeRoot(midpoint + 1, right, root, nums);
        
        return newNode;
    }
}
