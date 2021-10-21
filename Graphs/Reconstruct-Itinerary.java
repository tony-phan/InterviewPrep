class Solution {
    /*
    Understand 
    Input: list of airline tickets
           each ticket: [departure, arrival]
    Output: itinerary of all tickets in smallest lexical order
    Each ticket can only be used once but we want to make sure we use all tickets
    Can revisit nodes
    All itineraries start at JFK
    
    EX: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    JFK -> KUL, NRT
    KUL ->
    NRT -> JFK
    
    Match
    Graph - Edge list representation
    DFS traversal - instead of keeping track of which nodes we've been to, keep track of which tickets we've used (do a modified DFS)
    
    Plan
    Adjacency List: JFK -> ATL, SFO
                    ATL -> JFK, SFO
                    SFO -> ATL
    Convert the edge list into an adjacency list, use a priority queue so we the neighbors can be sorted        
    do a dfs starting from JFK
    DFS Search
        Grab the current airports neighbors
        if the current airport has no outgoing edges then it's the last airport in the result list
        while we haven't visited all of the current node's neighbors
        poll from the queue
        recursively call dfs again on neighboring node
    finally, add the node into result list
    reverse the result list and return
    
    Evaluate
    Time: O(N * log(n))
    Space: O(N)
    */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjacencyList = new HashMap<>();
        int numTickets = 0;
        // convert edge list into an adjacency list
        for(List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if(!adjacencyList.containsKey(source)) {
                adjacencyList.put(source, new PriorityQueue<>());
            }
            adjacencyList.get(source).add(destination);
            ++numTickets;
        }
        
        List<String> result = new ArrayList<>();
        dfs(adjacencyList, result, "JFK");
        Collections.reverse(result);
        return result;
    }
    private void dfs(Map<String, Queue<String>> adjacencyList, List<String> result, String airport) {
        Queue<String> nextAirports = adjacencyList.get(airport);
        if(nextAirports == null) {
            result.add(airport);
            return;
        }
        
        while(!nextAirports.isEmpty()) {
            String nextAirport = nextAirports.poll();
            dfs(adjacencyList, result, nextAirport);
        }
        result.add(airport);
    }
}
