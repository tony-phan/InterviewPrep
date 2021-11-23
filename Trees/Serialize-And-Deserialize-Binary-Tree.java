/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    /*
    Understand
    We are given a binary tree as input and we want to implement 2 methods that serialize and deserialize the tree
    serialize: convert the tree to a string representation
               Example:         1
                             2    3     (serialize) ->      1,2,x,x,3,4,x,x,5,x,x
                                 4 5
    deserialize: convert the serialized string back to a tree
                 Example:
                            1,2,x,x,3,4,x,x,5,x,x      (deserialize) ->        1
                                                                             2   3
                                                                                4 5
    What if we have negative values? we will want to use commas in the serialized string to seperate the values
    
    Match
    Binary Tree problem
    DFS traversal (pre order)
    
    Plan
    Serialize: do a dfs (pre order traversal) on the tree and add the values into a result string
               if we hit a null node, then add "x," to represent a null value
    Deserialize: split the serialized string with "," as a delimiter and add all the values into a queue
                 we want to create a tree from all the values in the queue by traversing in a pre order fashion
                 first poll from the queue
                    if the polled value is null or equals "x", return null
                    else
                        create a new treenode with the value of the polled value
                        recursively call the dfs function on the queue and set that equal to left child
                        recursively call the dfs function on the queue and set that equal to right child
                        return the root
    
    Evaluate
    Space
        Serialize: O(N)
        Deserialize: O(N)
    Time
        Serialize: O(N)
        Deserialize: O(N)
    */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "x,";
        }
        String result = "";
        result += root.val + ",";
        result += serialize(root.left);
        result += serialize(root.right);
        return result;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] array = data.split(",");
        for(String s : array) {
            queue.add(s);
        }
        TreeNode result = dfs(queue);
        return result;
    }
    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if(val == null || val.equals("x")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
