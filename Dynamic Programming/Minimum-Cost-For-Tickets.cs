public class Solution
{
    public int MincostTickets(int[] days, int[] costs)
    {
        int n = days[days.Length - 1];
        int[] dp = new int[n + 1];

        HashSet<int> set = new HashSet<int>(days);
        for (int i = 1; i < dp.Length; ++i)
        {
            if (!set.Contains(i))
            {
                dp[i] = dp[i - 1];
                continue;
            }

            int pass1 = (i - 1) >= 0 ? costs[0] + dp[i - 1] : costs[0];
            int pass7 = (i - 7) >= 0 ? costs[1] + dp[i - 7] : costs[1];
            int pass30 = (i - 30) >= 0 ? costs[2] + dp[i - 30] : costs[2];
            dp[i] = Math.Min(pass1, Math.Min(pass7, pass30));
        }

        // Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp.Last();
    }
}

/*
days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11

dp= [0,2,2,2,4,4,6,7,9,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
                     i
i=8
    - A (1 day pass) : $2  + dp[i-1]  = $9
    - B (7 day pass) : $7  + dp[i-7]  = $9
    - C (30 day pass): $15 + dp[i-30] = $15


days = [1,4,6], costs = [2,7,15]
        0 1 2

dp = [0,2,2,2,4,4,6]
      0 1 2 3 4 5 6
                  i

i=6
    - A (1 day pass) : cost[0] + dp[i-1]  = $6
    - B (7 day pass) : cost[1] + dp[i-7]  = $7      
    - C (30 day pass): cost[2] + dp[i-30] = $15     
    
dp[i] = Min(A,B,C)
    check boundaries when calculating A,B, and C

*/