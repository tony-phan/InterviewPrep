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
    BFS
    
    Plan
    do a bfs traversal on the tree
    for each level we're at in the traversal, keep a running sum for the levels
    the first leaf node we hit, break out of the dfs and return the running sum
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean foundLeaf = false;
        
        while(!queue.isEmpty()) {
            // the number of nodes in the current level we're at
            int numNodes = queue.size();
            ++result;
            for(int i = 0; i < numNodes; ++i) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left == null && currentNode.right == null) {
                    foundLeaf = true;
                    break;
                }
                
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            if(foundLeaf) {
                break;
            }
        }
        return result;
    }
}
