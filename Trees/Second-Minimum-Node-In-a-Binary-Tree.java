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
    we want to find the second most minimum node value in the entire tree
    if it does not exist then return -1
    
    Match
    Binary tree
    DFS search (probably want to do an in order traversal)
    
    Plan
    do a dfs traversal on the tree
    for each node we're at keep track of which node values we've seen using a set
    if the set does not contain the value
        add it to a list holding all unique values
    
    if the list's size is less than two return -1
    else return the second value in the list after sorting it
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        inOrderTraversal(list, set, root);
        
        int result = -1;
        if(list.size() >= 2) {
            Collections.sort(list);
            result = list.get(1);
        }
        
        return result;
    }
    
    private void inOrderTraversal(List<Integer> list, Set<Integer> set, TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(list, set, root.left);
        if(!set.contains(root.val)) {
            set.add(root.val);
            list.add(root.val);
        }
        inOrderTraversal(list, set, root.right);
    }
}
