class Solution {
    /*
    Understand
    We are given an int array and a target value
    We want to find out which three nums in the array have the closest sum to target
    
    Example: Input: nums = [-1,2,1,-4], target = 1
             Output: 2
             Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
    Match
    Array problem
    variant of the 3Sum problem?
    
    Plan
    This is pretty brute force, but this code checks all tuples, computes their sum, and stores the result if it's less than the current minimum difference 
    for i to nums.length - 2
        for j to nums.length - 1
            for k to nums.length
                sum = nums[i]+nums[j]+nums[k]
                difference = absolute difference of target - sum
                if difference < minimumDifference
                    minDiff = difference
                    result = sum
    Evaluate
    Time: O(n^3)
    Space: O(1)
    */
    public int threeSumClosest(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int result = 0;
        
        for(int i = 0; i < nums.length - 2; ++i) {
            for(int j = i + 1; j < nums.length - 1; ++j) {
                for(int k = j + 1; k < nums.length; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int difference = Math.abs(sum - target);
                    if(difference < minDifference) {
                        minDifference = difference;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
