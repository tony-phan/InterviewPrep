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
    Use a stack to iteratively traverse the graph
    Push the value of the input node into the stack
    while the stack's not empty
    pop a node from it
    if the map does not contain a key for the node's value, create a new node with the same value and put it into the map
    loop through the popped nodes neighbors
    if the map does not contain a key for the neighbor node's value, create a neighbor copy node and add it to the map
    push the neighbor into the stack
    add the copy neighbor node into the current node's neighbors
    
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
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            if(!adjacencyList.containsKey(top.val)) {
                Node copy = new Node(top.val);
                adjacencyList.put(top.val, copy);
            }
            
            for(Node neighbor : top.neighbors) {
                if(!adjacencyList.containsKey(neighbor.val)) {
                    adjacencyList.put(neighbor.val, new Node(neighbor.val));
                    stack.push(neighbor);
                }
                ((adjacencyList.get(top.val)).neighbors).add(adjacencyList.get(neighbor.val));
            }
        }
        return adjacencyList.get(node.val);
    }
}
