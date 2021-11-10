class Solution {
    /*
    Understand 
    [1,2,3,1]
     0 1 2 3
    output: 4
  dp[1,2,]
    
    [6,2,3,10]
     0 1 2 3
  dp[6,6,9,16]  
    Math.max(nums[i], nums[i - 1])
    if math.max == nums[i]
        dp[i] = nums[i] + dp[i-2]
    max sum you can get without summing adjacent values
    
    We want to use DP to store the max amount we've robbed so far
    Example: nums = [6,2,3,10]
         dp array = [6,6,9,16] dp[i] will store the max value robbed value up to the i^th house
                         
    
    Match
    Dynamic Programming
    
    Plan
    use a dp array to memoize the max amounts of homes we've seen so far
    dp[0] = val of first house
    dp[1] = max of value of first and second house
    for i = third house to the last house
        calculate the current robbed amount = nums[i] + dp[i - 2]
        set dp[i] = max(current robbed amount, dp[i - 1])
    return last value in dp array
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; ++i) {
            int robbedAmount = nums[i] + dp[i - 2]; // we do dp[i - 2] b/c we want to ignore adjacent homes
            dp[i] = Math.max(robbedAmount, dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
