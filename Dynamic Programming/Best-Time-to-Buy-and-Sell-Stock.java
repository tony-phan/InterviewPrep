class Solution {
    /*
    Understand
    We are given an int array as input
    Each value in the array represents the price of a stock on the i^th day
    We want to calculate the max profit by choosing a day to buy stock and a different day in the future to sell it
    Return the max possible profit, return 0 if there is no possible max profit
    
    [7,1,5,3,6,4]
     1 2 3 4 5 6
 dp:[0,0,4,4,5,5]
    min: 1
    
    dp[i] equals the max profit for the i^th day (also considering prices of previous days)
    dp array: [0,0,4,4,5,5]
               0 1 2 3 4 5 (0 index, day 0 is actually day 1)
               dp[2] = 4 (day 3 has a max profit of 4)
               dp[3] = 4 (day 4 has a max profit of 4)
    As we are checking each new day in the array, we want to keep an updated value holding the minimum prices from the days we've seen so far
    
    Match
    Dynamic Programming
    
    Plan
    If the number of day == 1, return 0
    Use an int array to store the max profits so far at the i^th day
    dp[0] = 0 b/c you cannot buy and sell on the same day
    set the minimum stock price we've seen so far = prices[0] (we assume the minimum price is day 0 at the start)
    from day 2 all the way to the last day:
        calculate the maxProfit: prices[i] - minimumPrice
        if the maxProfit > maxProfit of previous day (dp[i-1])
            dp[i] = maxProfit
        else 
            dp[i] = max profit of previous day (dp[i-1])
        minimumPrice = min(minimumPrice, prices[i])
    return maxProfit of last day    
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        
        int totalDays = prices.length;
        int[] dp = new int[totalDays];
        dp[0] = 0; //day 0 will always have maxprofit of 0 b/c you cannot buy & sell on same day
        int minimumPrice = prices[0];
        for(int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - minimumPrice;
            if(profit > dp[i - 1]) {
                dp[i] = profit;
            }
            else {
                dp[i] = dp[i - 1];
            }
            minimumPrice = Math.min(minimumPrice, prices[i]);
        }
        return dp[totalDays - 1]; // return maxprofit of the last day
    }
}
