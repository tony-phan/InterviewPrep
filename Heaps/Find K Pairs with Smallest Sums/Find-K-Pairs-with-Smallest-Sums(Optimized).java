class Solution {
    /*
    Match
    Min Heap: we want to find the k smallest pair sums
    
    Create a min heap that will store k pairings and order by minimum sums
    loop through nums1 and num2 to create pairings
    Add the pairings into the minHeap, remove elements as needed if the heap size > k
    put all elements in heap into result array and return
    
    Evaluate
    Time: O(n)
    Space: O(k)
    
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        Comparator<List<Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(List<Integer> pair1, List<Integer> pair2) {
                int pair1Sum = pair1.get(0) + pair1.get(1), pair2Sum = pair2.get(0) + pair2.get(1);
                
                if(pair1Sum == pair2Sum) {
                    return 0;
                }
                else if(pair1Sum < pair2Sum) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        };
        
        Queue<List<Integer>> heap = new PriorityQueue<>(comparator);
        
        for(int i = 0; i < nums1.length; ++i) {
            heap.add(Arrays.asList(nums1[i], nums2[0], 0));
        }
        
        while(k > 0 && !heap.isEmpty()) {
            --k;
            List<Integer> pair = heap.poll();
            result.add(Arrays.asList(pair.get(0), pair.get(1)));
            
            if(nums2.length - 1 == pair.get(2)) {
                continue;
            }
            
            heap.add(Arrays.asList(pair.get(0), nums2[pair.get(2) + 1], pair.get(2) + 1));
        }        
        return result;
    }
}
