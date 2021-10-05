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
    BST Rules: all node values in the left subtree must be less than parent node's value
               all node values in the right subtree must be greater than parent node's value
                8
              /   \
            1      10     false
                  /  \
                 7    15
    Match
    Binary Search Tree
    
    Plan
    do a in order traversal of the tree
    if the tree is a valid binary search tree, then the in-order traversal should be in ascending order
    if the order is not in ascending order then return false
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public boolean isValidBST(TreeNode root) {   
        List<Integer> list = new ArrayList<>();
        
        inOrderTraversal(root, list);
        return isSorted(list);
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
    private boolean isSorted(List<Integer> list) {
        if(list.size() == 1) {
            return true;    
        }
        
        boolean sorted = true;
        for(int i = 0; i < list.size() - 1; ++i) {
            if(list.get(i) >= list.get(i + 1)) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
