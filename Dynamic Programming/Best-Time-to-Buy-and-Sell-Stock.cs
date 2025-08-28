public class Solution
{
    public int MaxProfit(int[] prices)
    {
        int n = prices.Length;
        int[] dp = new int[n];
        dp[0] = 0;

        int minPrice = prices[0];
        for (int i = 1; i < n; ++i)
        {
            int maxProfit = prices[i] - minPrice;
            dp[i] = Math.Max(dp[i - 1], maxProfit);
            minPrice = Math.Min(minPrice, prices[i]);
        }

        // Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp[n - 1];
    }
}

/*
prices = [7,1,5,3,6,4]
              i
dp     = [0,0,]

minPrice = 1


dp[i] = Max(Max(prices[i] - prices[j]), dp[i-1]) where j < i
*/