class Solution {
    /*
    Understand
    We are given an int as input and we want to imagine there are n ways to reach the top
    we want to return the distinct ways to reach the top if we can only go 1 or 2 steps at a time
    
    This is similar to a fibonnaci because fib(n) = fib(n - 1) + fib(n - 2)
    If we did regular recursion, we would be doing a lot of repetitive computation, so dynamic programming would be applicable
    distinct ways of n = distinct ways of (n - 1) + distinct ways of (n - 2)
    
    Example: n = 2, output = 2
             There are two ways to climb to the top.
             1. 1 step + 1 step
             2. 2 steps
             n = 3, output = 3
             There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step
    Match
    Dynamic Programming
    
    Plan
    if the # of steps (n) is less than or equal to 2
        return n
    use an int array to store result of previous distinct ways at index i (memoization)
    Example: array [0,1,2,3,5,8]    at index = 5, there are 8 distinct ways
                    0 1 2 3 4 5     at index = 4, there are 5 distinct ways
    starting at index = 3 all the way to index = n
        distinct ways of i = distinct ways of (i - 1) + distinct ways of (i - 2)
    return dp[n]

    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public int climbStairs(int n) {
        // base case
        if(n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0; // 0 distinct ways to climb 0 steps 
        dp[1] = 1; // 1 distinct way to climb 1 step
        dp[2] = 2; // 2 distinct ways to climb 2 steps
        for(int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
