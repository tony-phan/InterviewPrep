/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Understand 
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Match
    Tree problem
    DFS traversal - postorder
    
    Plan
    Perform a postorder trasversal on the tree
    There's 3 scenarios:
    1. the current node has p and q in its left & right subtress (either p is in left subtree and q is in right subtree or vice versa)
    2. the current node equals p, and q is a decendant of p
    3. the current node equals q, and p is a decendant of q
    
    base case: root equals null or equals p or equals q
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) {         // the current root has p and q in it's left & right subtrees
            return root;
        }
        else if(left != null && right == null) {    // the current root has p and q in its left subtree
            return left;
        }
        else if(left == null && right != null) {    // the current root has p and q in its right subtree
            return right;
        }
        else {                                      // the current root does not have p and q in its left & right subtree
            return null;
        }
    }
}
