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
    3       8       output: 1  
   1 4         12            3
                              4
                               5
                                8
                                 12
    Match
    Binary Search Tree
    DFS preorder traversal
    
    Plan
    Do a dfs preorder traversal through the tree and use an list to store the ordering of the nodes
    loop through the list set all left children to null and right children to the next node
    return the result tree
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        TreeNode result = new TreeNode(-1);
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root, list);
        
        TreeNode currentNode = result;
        for(TreeNode node : list) {
            currentNode.right = node;
            currentNode = currentNode.right;
            currentNode.left = null;
        }
        
        root = result.right;
    }
    
    private void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }
        
        list.add(root);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    } 
}
