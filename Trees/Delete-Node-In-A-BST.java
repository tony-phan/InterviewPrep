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
    We are given a BST as input and a key
    We want to delete a node in the tree with the value of key
    Return the reformmated tree after deleting the key
    
    Match
    BST problem
    DFS traversal
    
    Plan
    Do a DFS (in order traversal) on th BST and store the ordering in a list (the list should be in sorted order)
    If the key is not in the list, then there is nothing to delete so return root
    if the key is in the list, remove the key from the list
    Convert the sorted list to a binary search tree
    Return the new tree
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        List<Integer> inOrder = new ArrayList<>();
        dfs(root, inOrder);
        if(!inOrder.contains(key)) {
            return root;
        }
        else {
            for(int i = 0; i < inOrder.size(); ++i) {
                if(inOrder.get(i) == key) {
                    inOrder.remove(i);
                    break;
                }
            }
        }
        
        return convertToBST(0, inOrder.size() - 1, inOrder);
    }
    
    private void dfs(TreeNode root, List<Integer> inOrder) {
        if(root == null) {
            return;
        }
        
        dfs(root.left, inOrder);
        inOrder.add(root.val);
        dfs(root.right, inOrder);
    }
    
    private TreeNode convertToBST(int left, int right, List<Integer> inOrder) {
        if(left > right) {
            return null;
        }
        
        int midPoint = (left + right)/2;
        TreeNode node = new TreeNode(inOrder.get(midPoint));
        node.left = convertToBST(left, midPoint - 1, inOrder);
        node.right = convertToBST(midPoint + 1, right, inOrder);    
        return node;
    }
}
