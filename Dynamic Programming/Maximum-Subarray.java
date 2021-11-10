class Solution {
    /*
    Understand
    We are given an int array 
    We want to return the max sum value of a contiguous subarray and return it
    Example: [-2,1,-3,4,-1,2,1,-5,4], output = 6
             Explanation: the subarray [4,-1,2,1] has the largest sum = 6.
             
             [5,4,-1,7,8], output = 23
             
    Brute force: we can generate every contigious subarray and calculate the max sum
    Optimized (DP): use dp to store the max sum for each i^th value in the array
                    dp[i] = the max contiguous sum at index position i
                    Example: input = [-2,1,-3,4,-1,2,1,-5,4]
                                dp = [-2,1, 1,4, 4,5,6, 6,6]
                    we will have to keep track of the current subarray sum (Math.max(currentSum + nums[i], nums[i]))
    
    Match
    Array Problem
    Dynamic Programming
    
    Plan
    if nums size == 1
        return nums[0]
    
    dp = new int[nums.length]
    dp[0] = first val in nums
    currentSum = firstVal in nums
    for i = second val in nums to last val in nums
        currentSum = max(currentNum + nums[i], nums[i])
        dp[i] = max(dp[i - 1], currentSum)
    return last val in dp array
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        int currentSum = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            dp[i] = Math.max(dp[i - 1], currentSum);
        }
        return dp[dp.length - 1];
    }
}
