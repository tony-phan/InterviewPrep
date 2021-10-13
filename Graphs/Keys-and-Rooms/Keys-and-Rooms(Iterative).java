class Solution {
    /*
    Understand
    rooms = [[],[],[2]]
    output: false
    
    Match
    Graph
    DFS Traversal
    
    Plan
    Start at room 0
    Use a set to keep track of rooms we've visited
    use a stack to perform dfs traveral and hold all the keys we have rooms to visit to
    while we have keys in the stack
        add the room to rooms we've visited
        add the keys in that room into the stack so we can visit those rooms
    return if the number of rooms we've visited == total number of rooms
    
    Evaluate
    Time: O(N + K)
          N - # of rooms, K - # of keys
    Space: O(N)
    */
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) {
            return false;
        }
        
        Set<Integer> roomsVisited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.add(0);
        
        while(!stack.isEmpty()) {
            int room = stack.pop();
            
            if(!roomsVisited.contains(room)) {
                roomsVisited.add(room);
            }
            
            for(int keys : rooms.get(room)) {
                if(!roomsVisited.contains(keys)) {
                    stack.push(keys);
                }
            }
        }
        return roomsVisited.size() == rooms.size();
    }
}
