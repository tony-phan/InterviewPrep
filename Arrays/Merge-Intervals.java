class Solution {
    /*
    interval 1: [1,4]
    interval 2: [4,6]
    
    to check overlap, compare the end of interval 1 with the start of interval 2
    anytime the start of interval 2 is less than or equal to the end of interval 1, then they overlap
    
    cannot assume they are sorted
    what if there are more than 1 overlaps?
    
    [[1,3],[2,6],[3,4],[15,18]]
                           i    
    [[1,6]]
     
    first check if there is an intersection 
    if there is an intersection, then we want to determine the new start and new end of the merged interval
    new start will always be the start of left interval
    new end will be the max of the left&right interval's end
    
    Evaluate
    Time: O(NlogN)
    Space: O(N)
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; ++i) {
            int[] leftInterval = result.get(result.size() - 1);
            int[] rightInterval = intervals[i];
            
            if(leftInterval[1] >= rightInterval[0]) {
                leftInterval[1] = Math.max(leftInterval[1], rightInterval[1]);
            }
            else {
                result.add(rightInterval);
            }
        }
        int[][] solution = result.toArray(new int[result.size()][]);
        return solution;
    }
}
