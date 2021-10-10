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
    Inorder traversal - left, root, right
    
    Match
    Binary Search Tree
    In order traversal (iterative)
    
    Plan
    Use a stack to iteratively traverse the tree
    Inorder: push the left, then root, and finally right into the stack
    Use a treenode pointer to keep track of the node we're at
    while the stack is not empty and the pointer not equal to null
        keep adding the left children into the stack
        once there are no more left children pop from the stack and add into the result list
        set the current pointer to it's right child and continue on in the loop
        
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
}
