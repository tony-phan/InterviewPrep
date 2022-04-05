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
    Use Union Find
    First create a list of of size n called ids
    ids[i] : the parents of the ith node
    for each edge union them 
    the # of connected components equals the number of unique parents
    
    
    Evaluate
    Time: O(N + Mlog(N))
    Space: O(N)
    */
    
    public int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        // initially, point all nodes to themselves
        for(int i = 0; i < n; ++i) {
            ids[i] = i;
        }
        
        // combine the subsets
        for(int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            
            union(ids, vertex1, vertex2);  
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < ids.length; ++i) {
            set.add(find(ids, i));
        }
        return set.size();
    }
    
    // combine the subsets of vertex1 and vertex2 by setting one to be the parent of the other
    private void union(int[] ids, int vertex1, int vertex2) {
        int vertex1Parent = find(ids, vertex1);
        int vertex2Parent = find(ids, vertex2);
        
        ids[vertex1Parent] = vertex2Parent;
    }
    
    // find the parent of the vertex argument
    private int find(int[] ids, int vertex) {
        // base case
        if(ids[vertex] == vertex) {
            return vertex;
        }
        
        int parent = find(ids, ids[vertex]); 
        ids[vertex] = parent; // path compression
        return parent;
    }
}
