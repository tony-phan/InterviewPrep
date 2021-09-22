class Solution {
    /*
    Understand
    
    Match
    Use priority queue for get k closest
    
    Plan
    Create a priority queue (store closest points at end, and furthest points at head)
    add points into the queue
        if the queue size > k, remove a point from the queue
    add all remaining points in the queue to the result array
    
    Evaluate
    Time: O(n * log(k))
    Space: O(k)
    */
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                double point1Distance = euclideanDistanceFromOrigin(point1[0], point1[1]);
                double point2Distance = euclideanDistanceFromOrigin(point2[0], point2[1]);
                
                if(point1Distance == point2Distance) {
                    return 0;
                }
                else if(point1Distance < point2Distance) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        
        Queue<int[]> heap = new PriorityQueue<>(comparator);
        for(int i = 0; i < points.length; ++i) {
            int[] point = points[i];
            
            heap.add(point);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        for(int i = 0; i < result.length; ++i) {
            int[] point = heap.poll();
            
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        
        return result;
    }
    
    private double euclideanDistanceFromOrigin(int x, int y) {
        return Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
    }
}
