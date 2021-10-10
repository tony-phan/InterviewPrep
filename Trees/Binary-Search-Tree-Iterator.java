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
class BSTIterator {
    /*
    Match
    BST
    DFS - in order traversal
    
    Plan
    Use a queue to maintain the ordering of the in order tree traversal
    anytime we call next(), remove from the queue and get the value
    anytime we call hasNext(), just check if the queue is not empty
    
    Evaluate
    next: Time - O(1), Space - O(n)
    hasNext: Time - O(1), Space - O(n)
    */
    Queue<TreeNode> queue;
    
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inOrderTraversal(queue, root);
    }
    
    public int next() {
        return (queue.poll()).val;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    private void inOrderTraversal(Queue<TreeNode> queue, TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrderTraversal(queue, root.left);
        queue.add(root);
        inOrderTraversal(queue, root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
