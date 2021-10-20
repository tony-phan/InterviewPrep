class Solution {
    /*
    Understand
    Return the ordering of courses to take to finish all courses
    Basically...make sure we take all prerequisites first (topological sort)
    Check if there exist a cycle in the graph
    
    Match
    Graph - edge list representation
    Topological sort - order all nodes in the graph such that nodes without dependencies come before nodes with dependencies
    DFS traversal to check for cycles in the graph
    
    Plan
    Convert the edge list into an adjacency list
    Perform a DFS traversal through the adjacency list to detect if cycles exist
    Use a deque to store the topological ordering
    if a cycle exists return an empty array
    else return the topological order
    
    Evaluate
    Time: O(V + E)
    Space: O(V + E)
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            return null;
        }
        
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < numCourses; ++i) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            int classA = prerequisite[0];
            int classB = prerequisite[1];
            (adjacencyList.get(classB)).add(classA);
        }
        
        Deque<Integer> topologicalSort = new ArrayDeque<>();
        int UNVISITED = 0, VISITING = 1, DONE_VISITING = 2;
        int[] nodeColors = new int[numCourses];
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(adjacencyList, nodeColors, topologicalSort, i)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        toArray(topologicalSort, result);
        return result;
    }
    // return true if there exist no cycles, false if there exists a cycle
    private boolean dfs(Map<Integer, List<Integer>> adjacencyList, int[] nodeColors, Deque<Integer> topologicalSort, int node) {
        if(nodeColors[node] == DONE_VISITING) {
            return true;
        }
        if(nodeColors[node] == VISITING) {
            return false;
        }
        
        nodeColors[node] = VISITING;
        List<Integer> neighbors = adjacencyList.get(node);
        for(Integer neighbor : neighbors) {
            if(!dfs(adjacencyList, nodeColors, topologicalSort, neighbor)) {
                return false;
            }
        }
        topologicalSort.addFirst(node);
        nodeColors[node] = DONE_VISITING;
        return true;
    }
    
    private void toArray(Deque<Integer> topologicalSort, int[] result) {
        for(int i = 0; i < result.length; ++i) {
            result[i] = topologicalSort.poll();
        }
    }
}
