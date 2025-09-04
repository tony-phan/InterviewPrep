public class Solution
{
    public int CoinChange(int[] coins, int amount)
    {
        Dictionary<int, int> dp = new Dictionary<int, int>();
        foreach (int coin in coins)
        {
            dp[coin] = 1;
        }

        return helper(coins, amount, dp);
    }

    private int helper(int[] coins, int amount, Dictionary<int, int> dp)
    {
        if (amount == 0)
        {
            return 0;
        }
        else if (amount < 0)
        {
            return -1;
        }
        else if (dp.ContainsKey(amount))
        {
            return dp[amount];
        }

        int result = int.MaxValue;
        foreach (int coin in coins)
        {
            int coinAmount = helper(coins, amount - coin, dp);
            if (coinAmount == -1)
            {
                continue;
            }
            result = Math.Min(result, coinAmount + 1);
        }
        dp[amount] = (result == int.MaxValue) ? -1 : result;
        return dp[amount];
    }
}

/*

                                                coinChange(6,0) 
coins = [2], amount = 3
5+5+2 
1+1+1+1+1+1+1+1+1+1+1
2+2+2+2+2+1

                                    coinChange(6) 
        1st level: coinchange(5)    coinchange(4)   coinchange(1)
        2nd level:       1                                1      
        3rd level:     coinchange(3)coinchange(2)coinchange(-1)
                                         1           -1
4th level:coinchange(2)coinchange(1)coinchange(-2)
               1             1            -1

int minCoinAmount
int coinAmount = dp(amount - coin, numCoins)
minCoinAmount = Min(minCoinAmount, coinAmount)

dp[i] = Min(coinCount, 1+dp[i-coin]) 
*/