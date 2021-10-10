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
    for any two nodes in the entire, we want to get the minimum difference between those two nodes
    
    Match
    Binary Search Tree
    DFS - in order traversal because we want t go from top-down
    
    Plan
    Do a dfs (in order) traversal through the tree
    the dfs will return a list of the values sorted
    calculate the minimum difference by looping through the list and getting the different of every two values
    return the minimum difference
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(list, root);
        
        int result = Integer.MAX_VALUE;
        int left = 0, right = left + 1;
        while(right < list.size()) {
            result = Math.min(result, Math.abs(list.get(left) - list.get(right)));
            ++left;
            ++right;
        }
        
        return result;
    }
    
    private void inOrderTraversal(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(list, root.left);
        list.add(root.val);
        inOrderTraversal(list, root.right);
    }
}
