class Solution {
    /*
    Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
                  
    gaps:
      row0: [1,3,5]
      row1: [3,4]
      row2: [1,4]
      row3: [2]
      row4: [3,4]
      row5: [1,4,5]


    for a row of size 6 the endIndexes are: 1   2    3    4    5    6 
                                            (g1) (g2) (g3) (g4) (g5)        g1 = gap 1 
    for each column in the brick wall, we want to keep track of how many bricks it crosses (use a hashmap for that)
    Plan: Create a HashMap to store the number of gaps at each gapNum
          loop through each row, for each gapNum we're at we want to update the # of gaps at that gap number
          loop through the hashmap, find the value for which we have the max number of gaps
          the answer is equal to: # of rows - max number of gaps (doesnt matter what gap number is)    
    
    Evaluate
    Time: O(N * M)
            N = number of rows, M = number of bricks per row
    Space: O(A)
            A = width of row - 1
    */
    public int leastBricks(List<List<Integer>> wall) {
        // key = endIndex of the row, value = # of untouched bricks for that endIndex
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall) {
            int gapNum = 0;
            // we do row.length - 1 because we dont care about the last element
            for(int i = 0; i < row.size() - 1; ++i) {
                gapNum += row.get(i);
                
                if(!map.containsKey(gapNum)) {
                    map.put(gapNum, 1);
                }
                else {
                    map.put(gapNum, map.get(gapNum) + 1);
                }
            }
        }
        
        int maxGaps = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxGaps = Math.max(maxGaps, entry.getValue());
        }
        
        return wall.size() - maxGaps;
    }
}
