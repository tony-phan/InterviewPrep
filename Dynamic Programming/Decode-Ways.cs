public class Solution
{
    public int NumDecodings(string s)
    {
        if (s[0] == '0')
        {
            return 0;
        }

        int n = s.Length + 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < s.Length; ++i)
        {
            int singleDigit = int.Parse("" + s[i]);
            if (singleDigit != 0)
            {
                dp[i + 1] += dp[i];
            }

            int doubleDigit = int.Parse("" + s[i - 1] + s[i]);
            if (10 <= doubleDigit && doubleDigit <= 26)
            {
                dp[i + 1] += dp[i - 1];
            }
        }

        Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp.Last();
    }
}

/*
Input: s = "2368"
              i

dp = [1,1,2,2]

i=1 
dp[1]=dp[i-1]+dp[i-2]
dp[2]=dp[i-1]

Output: 3

*/