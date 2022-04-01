class Solution {
    /*
    You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

    Return the number of connected components in the graph.
    Example: Input: n = 5, edges = [[0,1],[1,2],[3,4]]
    
             0-1   3
               |   |   output: 2
               2   4
    
            1-2
              |  0   output: 2
              3
              
    Plan
    First we build an adjacency list 
    use a set to store node we have already seen
    perform a dfs on the graph and store nodes we've visited in the set
    update result anytime a node has not been visited yet before out dfs search
    return the result
    
    Evaluate
    Time: O(N + E)
    Space: O(N)
    */
    
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            adjacencyList.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            
            (adjacencyList.get(vertex1)).add(vertex2);            
            (adjacencyList.get(vertex2)).add(vertex1);
        }
        
        Set<Integer> visited = new HashSet<>();
        for(Integer node : adjacencyList.keySet()) {
            if(!visited.contains(node)) {
                ++result;
                dfs(adjacencyList, node, visited);
            }
        }
        return result;
    }
    
    private void dfs(Map<Integer, List<Integer>> adjacencyList, int node, Set<Integer> visited) {
        if(visited.contains(node)) {
            return;
        }
        
        visited.add(node);
        for(int neighbor : adjacencyList.get(node)) {
            dfs(adjacencyList, neighbor, visited);
        }
    }
}
