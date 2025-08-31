public class Solution
{
    public int MaxProfit(int[] prices)
    {
        int n = prices.Length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; ++i)
        {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0)
            {
                dp[i] = profit + dp[i - 1];
            }
            else
            {
                dp[i] = dp[i - 1];
            }
        }
        // Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp[n - 1];
    }
}

/*
prices = [7,1,5,3,6,4]
                    i 
dp     = [0,0,4,4,7,7]
profit    = -2

if profit > 0
    dp[i] = (prices[i] - prices[i-1]) + dp[i-1]
else
    dp[i] = dp[i-1]

*/