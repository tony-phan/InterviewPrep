public class Solution
{
    public int MinCostClimbingStairs(int[] cost)
    {
        int n = cost.Length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; ++i)
        {
            dp[i] = Math.Min(
                cost[i - 1] + dp[i - 1],
                cost[i - 2] + dp[i - 2]
            );
        }
        return dp[n];
    }
}

/*
cost = [1,100,1,1,1,100,1,1,100,1]
                                   i
dp   = [0,  0,1,2,2,  3,3,4,  4,5, 6]

cost = [10,15,20] 
                 i
dp   = [ 0, 0,10,0]
                 t
dp[i] = Min(
        cost[i-1] + dp[i-1],
        cost[i-2] + dp[i-2]
    )
*/