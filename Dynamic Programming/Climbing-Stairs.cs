public class Solution
{
    public int ClimbStairs(int n)
    {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp[n];
    }
}

/*
n = 3
result = 3
dp = [0,1,2,3]
      0 1 2 3
dp[i] = distinct ways to climb to i

dp[3]=dp[3-1]+dp[3-2]=3

dp[i] = dp[i-1] + dp[i-2]


n = 6
dp = [0,1,2,3,5,8,13]
      0 1 2 3 4 5 6
                i

*/