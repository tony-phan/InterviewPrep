class Solution {
    /*
    Understand
    We are given an int array as input and a target value
    Our output will be the index of two numbers in the array whose sum is the target
    We can assume there is exactly one solution
    The array is in sorted order
    The array is 1-indexed
    
    Example: [2,7,11,15], target = 9
             Output: [1,2] (2+7 == 9)
    
    Match
    Array problem
    Two Pointer
    
    Plan
    Use a left pointer at the start of the list and a right pointer at the end
    while the left pointer is less than right
        calculate their sum
        if the sum is less than target
            move left pointer right
        if the sum is greater than target
            move the right pointer left
        if the sum equals target
            the result is [leftPointer+1,rightPointer+1]
    return result
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target) {
                ++left;
            }
            else if(sum > target) {
                --right;
            }
            else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }
}
