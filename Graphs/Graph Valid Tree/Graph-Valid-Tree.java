class Solution {
    /*
    what are the rules for a valid tree? 
    1. There cannot be a cycle in the graph
    2. All node vertices must be connected (cannot have unconnected nodes)
    
    Match
    We can use union find to check if the graph is a valid tree
    What is union find? union-find is used to connect nodes in order to classify or, you may say, cluster informations, to show something has certain things similar. Those information showing the connection or similarity between nodes are described in edges. These edges might be weighted and directed in case that you need to know the importance and priority. For most of cases here, you might just use undirected and unweighted edges. By connecting edges together, you may know the root of those nodes.
    
    Plan
    For every edge we want to compare their parent or union them
        if their parents are the same, then there exists a cycle
        else, union them
    next we want to check there are no unconnected components
    if the number of unique parents == 1, then the graph is a valid tree
    
    Evaluate
    Time: O(N^2)
    Space: O(N)
    */
    
    public boolean validTree(int n, int[][] edges) {        
        int[] ids = new int[n];
        
        for(int i = 0; i < n; ++i) {
            ids[i] = i;
        }
        
        for(int[] edge : edges) {
            int vertex1Parent = find(ids, edge[0]);
            int vertex2Parent = find(ids, edge[1]);
            
            // this is responsible for detecting cycles
            if(vertex1Parent == vertex2Parent) {
                return false;
            }
            else {
                union(ids, vertex1Parent, vertex2Parent);
            }
        }
        
        // this is repsonsible for detecting unconnected components
        Set<Integer> parents = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            parents.add(find(ids, i));
        }
        
        return parents.size() == 1;
    }
    
    private void union(int[] ids, int vertex1, int vertex2) {
        int vertex1Parent = find(ids, vertex1);
        int vertex2Parent = find(ids, vertex2);
        
        ids[vertex1Parent] = vertex2Parent;
    }
    
    private int find(int[] ids, int vertex) {
        if(ids[vertex] == vertex) {
            return vertex;
        }
        
        int parent = find(ids, ids[vertex]);
        ids[vertex] = parent;
        return parent;
    }
}
