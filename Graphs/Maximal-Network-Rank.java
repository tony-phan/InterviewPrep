class Solution {
    /*
    Understand 
    We want to return the maximial network rank of entire infrastructure
    network rank: total # of directly connected roads to either city (if a road directly connects both cities, then only count that once)
    input: [[0,1],[0,3],[1,2],[1,3]] (edge list)
    output should be an int
    
    Match
    Graph problem
    
    Plan
    1. convert the edge list into a adjacency list 
    [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]] -> 0 - [1,3]
                                             1 - [0,2,3]
                                             2 - [1,3,4]
                                             3 - [0,1,2]
                                             4 - [2]
    2. generate all pairs of cities and calculate their network rank (keep track of the maximum rank so far)
       can possibly use a heap to avoid N^2 times (it will take O(N) extra space tho)
    3. return max rank
    
    Evaluate
    Time: O(N^2)
    Space: O(N)
    */
    
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            adjacencyList.put(i, new HashSet<>());
        }
        
        for(int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            (adjacencyList.get(city1)).add(city2);
            (adjacencyList.get(city2)).add(city1);
        }
        
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(j == i) {
                    continue;
                }
                
                int networkRank = 0;
                networkRank += (adjacencyList.get(i)).size();
                networkRank += (adjacencyList.get(j)).size();
                
                if((adjacencyList.get(i)).contains(j) || (adjacencyList.get(j)).contains(i)) {
                    --networkRank;
                }
                result = Math.max(result, networkRank);
            }
        }
        return result;
    }
}
