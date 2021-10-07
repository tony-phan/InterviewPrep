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
                8
            2       1
           3 7    -2 6          output: [8,2,7,8]
              8
    Match
    Binary tree
    BFS traversal since we want to go level by level in the tree
    
    Plan
    Do a BFS traversal on the tree
    For each level we're at we want to keep track of the max value at that level
    add the max level to our list after each level
    once finished traversing, return the list
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            int numNodesInLevel = queue.size();
            int maxValInLevel = Integer.MIN_VALUE;
            for(int i = 0; i < numNodesInLevel; ++i) {
                TreeNode node = queue.poll();
                maxValInLevel = Math.max(maxValInLevel, node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(maxValInLevel);
        }
        
        return list;
    }
}
