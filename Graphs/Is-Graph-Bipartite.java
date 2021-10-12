class Solution {
    /*
    Understand
    Bipartite graph: the graph in which you can split all the nodes into 2 sets and every edge in the graph connects a node in one set to the other set
    0 - 1  Node 0: [1, 3]     0 - 1  *all the edges in the graph connect a node from     
    |   |  Node 1: [0, 2] ->    \/    set (0 and 2) to set (1 and 3)
    3 - 2  Node 2: [1, 3]     2 - 3
           Node 3: [0, 2]
    
    Match
    Undirected graph
    DFS traversal
    
    Plan
    Graph coloring: Assign a color each for node in the graph
                    For a node we're at assign it a color, and then assign its adjacent nodes a different color (DFS traversal)
                    A bipartite graph will have no color conflicts
    Color Code: 0 - not colored
                1 - blue
               -1 - red
    For each node, if it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
    If it has been colored, check if the current color is the same as the color that is going to be used to color it. 
    
    Evaluate
    Time: O(V + E) v(vertices) e(edges)
    Space: O(V + E)
    */
    public boolean isBipartite(int[][] graph) {
        int[] nodeColors = new int[graph.length];
        for(int i = 0; i < graph.length; ++i) {
            if(nodeColors[i] == 0 && !validColor(graph, nodeColors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validColor(int[][] graph, int[] nodeColors, int color, int node) {
        if(nodeColors[node] != 0) {
            return nodeColors[node] == color;
        }
        
        nodeColors[node] = color;
        for(int adjacentNode : graph[node]) {
            if(!validColor(graph, nodeColors, -color, adjacentNode)) {
                return false;
            }
        }
        return true;
    }
}
