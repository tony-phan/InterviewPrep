class Solution {
    /*
    Understand
    We are given a number of courses and an array of prerequisites
    prerequisites[i] = [a, b], you must take course "b" first before taking course "a"
    Return true if we can take all classes
    
    numCourses = 2, prerequisites = [[1,0]]
        Map
        0 -> 1
        1 ->  
    
    Match
    Graph - edge list representation
    Cycle detection
    
    Plan
    Convert the edge list into an adjacency list
    Perform dfs on the graph to detect a cycle (use graph coloring to keep track of which nodes we're visiting and nodes we're done visiting)
    Cycle detection:
    if the node is done visiting return false
    if the node is in the process of being visited return true
    set the current node to being visited
    check the current node's neighbors
        if the current node's neighbor is is visited but not done visiting return false
    set the current node to done visiting
    return false
    If a cycle exists return false, else return true
    
    
    Evaluate
    Time: O(V+E)
    Space: O(V)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < numCourses; ++i) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            adjacencyList.get(b).add(a);
            
        }
        
        int[] nodeStates = new int[numCourses]; // 0 - unvisited, 1 - visiting, 2 - done visiting
        for(int i = 0; i < numCourses; ++i) {
            // if there is a cycle, then return false because we can not take all classes
            if(dfs(adjacencyList, i, nodeStates)) {
                return false;
            }
        }        
        return true;
    }
    // return true if there is a cycle, false if no cycle
    private boolean dfs(Map<Integer, List<Integer>> adjacencyList, int node, int[] nodeStates) {
        if(nodeStates[node] == 2) {
            return false;
        }
        else if(nodeStates[node] == 1) {
            return true;
        }

        nodeStates[node] = 1;
        List<Integer> neighbors = adjacencyList.get(node);
        for(Integer neighbor : neighbors) {
            boolean neighborHasCycle = dfs(adjacencyList, neighbor, nodeStates);
            if(neighborHasCycle) {
                return true;
            }
        }
        nodeStates[node] = 2;
        return false;
    }
}
