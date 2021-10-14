class Solution {
    /*
    Understand
    get the median of two sorted arrays
    
    Match
    Heap: can be used to store all numbers and order them
    
    Plan
    merge boths arrays into one list using a heap
    transfer all values in the heap to a list
    get the median of that list
        if the list size is even
            sum the two middle numbers and divide by 2
        if the list size is odd
            get the middle num
    return the median
    
    Evaluate
    Time: O(n)
    Space: O(nlog(n))
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        for(int num : nums1) {
            heap.add(num);
        }
        for(int num : nums2) {
            heap.add(num);
        }
        
        List<Integer> list = new ArrayList<>();
        while(!heap.isEmpty()) {
            list.add(heap.poll());
        }
        
        double result = 0;
        if(list.size() % 2 == 0) {
            result += list.get(list.size() / 2);
            result += list.get((list.size() / 2) - 1);
            result /= 2;
        }
        else {
            result = list.get(list.size() / 2);
        }
        return result;
    }
}
