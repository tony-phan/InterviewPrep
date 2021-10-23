/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
    Understand 
    We are given a reference to a node in a connected undirect graph
    Do a deep copy of the graph and return it
    
    Match 
    Graph problem
    DFS traversal
    
    Plan
    Create a hashmap to store the graph clone nodes
    call a dfs helper method on the input node
    DFS traversal
        if the map contains a key of the current node's value, end the traversal
        create a copy of the argument node and add it to the map
        for each of the node's neighbors
            if the map does not contain a key for the neighbors value, recursively call dfs on the neighbor
            add the neighbor into the copy node's neighbors
            
    return the copy of the graph
    
    Evaluate
    Time: O(V + E)
    Space: O(V)
    */
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Map<Integer, Node> adjacencyList = new HashMap<>();
        dfs(adjacencyList, node);
        return adjacencyList.get(node.val);
    }
    
    private void dfs(Map<Integer, Node> adjacencyList, Node node) {
        if(adjacencyList.containsKey(node.val)) {
            return;
        }
        
        Node newNode = new Node(node.val);
        adjacencyList.put(node.val, newNode);
        
        for(Node neighbor : node.neighbors) {
            if(!adjacencyList.containsKey(neighbor.val)) {
                dfs(adjacencyList, neighbor);
            }
            (newNode.neighbors).add(adjacencyList.get(neighbor.val));
        }
    }
}
