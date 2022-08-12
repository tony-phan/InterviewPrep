class Solution {
    /*
    Since the array is already sorted we can use this information to help us find two #'s in the array that sum to the target
    This is a two pointer problem so we'll have a left and right pointer 
    left will start at the first index and right will start at the last index
    if the sum of left & right is less than target, increment left pointer
    if the sum of left & right is less then target, decrement the right pointer
    if the sum of left & right equals the target, we found the solution
    keep doing these steps until the sum equals the target
    
    *incrementing the left pointer will make the sum increase, decrementing the solution will make the sum decrease (we can do this b/c the array is sorted)
    
    since this problem guarantees there is one solution, so we can always assume there is a solution pair 
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        int leftPointer = 0, rightPointer = numbers.length - 1;
        
        while(leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum < target) {
                ++leftPointer;
            }
            else if(sum > target) {
                --rightPointer;
            }
            else {
                result[0] = leftPointer + 1;
                result[1] = rightPointer + 1;
                break;
            }
        }
        return result;
    }
}
