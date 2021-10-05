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
            5
           /   \
          3     9        k = 4, output = 5
        /  \     \       k = 6, output = 12
        2   4     12     k = 2, output = 3
        
    Match
    Binary Search Tree
    
    Plan
    Do an in order traversal of the tree and store values in a list (list should be in ascending order)
    return the "k-1" indexed element
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        
        // we do "k - 1" b/c the list is 0 indexed
        return list.get(k - 1);
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
