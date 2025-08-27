public class Solution
{
    public int Rob(int[] nums)
    {
        int n = nums.Length;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
        {
            if (i < 2)
            {
                dp[i] = nums[i];
                continue;
            }

            int maxAmountRobbed = Math.Max(nums[i] + dp[i - 2], dp[i - 1]);
            dp[i] = maxAmountRobbed;
        }
        return dp[n - 1];
    }
}

/*
nums = [2,7, 9,3, 1]
                  i 
dp   = [2,7,11,10,12]

nums = [1,2,3,1]
            i
dp   = [1,2,4,3]

nums = [1,2,2,1]
              i
dp   = [1,2,3,3]

dp[i] = nums[i] + dp[i-2]
*/