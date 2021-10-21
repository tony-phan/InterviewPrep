class Solution {
    /*
    Understand
    Given an adjacency list as input
    A terminal node is a node without outgoing edges (no neighbors)
    Safe node: a node which has all its outgoing edges leading to a terminal node
    Find all safe nodes in ascending order
    
    Match
    Graph problem - adjacency list represenation
    This is basically another graph cycle detection problem
    
    Plan
    Do a DFS traversal through the graph
    if we detect a cycle at the current node, that means it's not a safe node so continue to the next node
    if there's no cycle at this node, add it to our result list (use a heap to maintain ascending order)
    return a list of all the safe nodes in ascending order
    
    Evaluate
    Time: O(V + E)
    Space: O(V)
    */
    
    int UNIVISTED = 0, VISITING = 1, DONE_VISITING = 2;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if(graph == null) {
            return new ArrayList<>();
        }
        
        int numNodes = graph.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> heap = new PriorityQueue<>();
    
        int[] nodeColors = new int[numNodes];
        for(int i = 0; i < numNodes; ++i) {
            if(!dfs(graph, nodeColors, i)) {
               continue; 
            }
            heap.add(i);
        }
        
        transferValues(heap, result);
        return result;
    }
    // return true if there exist no cycles in the graph, return false otherwise
    private boolean dfs(int[][] graph, int[] nodeColors, int node) {
        if(nodeColors[node] == DONE_VISITING) {
            return true;
        }
        
        if(nodeColors[node] == VISITING) {
            return false;
        }
        
        nodeColors[node] = VISITING;
        int[] neighbors = graph[node];
        for(int neighbor : neighbors) {
            if(!dfs(graph, nodeColors, neighbor)) {
                return false;
            }
        }
        nodeColors[node] = DONE_VISITING;
        return true;
    }
    
    private void transferValues(Queue<Integer> heap, List<Integer> result) {
        while(!heap.isEmpty()) {
            result.add(heap.poll());
        }
    }
}
