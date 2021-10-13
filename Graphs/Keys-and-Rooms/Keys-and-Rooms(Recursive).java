class Solution {
    /*
    Understand
    rooms = [[],[],[2]]
    output: false
    
    Match
    Graph
    DFS Traversal
    
    Plan
    for each room we're at, collect the keys
    visit all the rooms we have keys for (dfs traversal)
    for each room we've visited, keep track of the room we're at and the room's keys
        if we've already visited that room, stop traversal
        
    Start at room 0
    
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
        Set<Integer> keys = new HashSet<>();
        
        keys.add(0);
        
        for(int i = 0; i < rooms.size(); ++i) {
            int room = i;
            if(roomsVisited.contains(room)) {
               continue; 
            }
            else {
                if(keys.contains(room)) {
                    visitRoom(rooms, roomsVisited, keys, room);
                }
            }
        }
        return roomsVisited.size() == rooms.size();
    }
    
    private void visitRoom(List<List<Integer>> rooms, Set<Integer> roomsVisited, Set<Integer> keys, int currentRoom) {
        if(roomsVisited.contains(currentRoom)) {
           return; 
        }
        
        roomsVisited.add(currentRoom);
        List<Integer> keysInRoom = rooms.get(currentRoom);
        for(int key : keysInRoom) {
            if(!keys.contains(key)) {
               keys.add(key); 
            }
            visitRoom(rooms, roomsVisited, keys, key);
        }
    }
}
