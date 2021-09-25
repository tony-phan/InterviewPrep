}
class Solution {
    /*
    Match
    Min Heap: we want to find the k smallest pair sums
    
    Create a min heap that will store k pairings and order by minimum sums
    loop through nums1 and num2 to create pairings
    Add the pairings into the minHeap, remove elements as needed if the heap size > k
    put all elements in heap into result array and return
                              0 1 2
    nums1 = [1,1,2], nums2 = [1,2,3], k = 3
    heap: [[1,1,0],[1,1,0],[2,1,0]]
    result: []
    
    Evaluate
    Time: O(n)
    Space: O(k)
    
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> pair1, List<Integer> pair2) {
                int pair1Sum = pair1.get(0) + pair1.get(1);
                int pair2Sum = pair2.get(0) + pair2.get(1);
                
                return pair1Sum - pair2Sum;
            }
        });
        
        for(int i = 0; i < nums1.length; ++i) {
            heap.add(Arrays.asList(nums1[i], nums2[0], 0));
        }
        
        while(result.size() != k && !heap.isEmpty()) {
            List<Integer> pair = heap.poll();
            result.add(Arrays.asList(pair.get(0), pair.get(1)));
            
            if(pair.get(2) == nums2.length - 1) {
               continue; 
            }
            heap.add(Arrays.asList(pair.get(0), nums2[pair.get(2) + 1], pair.get(2) + 1));
        }
        return result;
    }
}
