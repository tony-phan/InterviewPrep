public class Solution
{
    public int Rob(int[] nums)
    {
        int n = nums.Length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.Max(nums[0], nums[1]);

        int[] dp1 = new int[n]; // rob first house
        int[] dp2 = new int[n]; // rob last house

        dp1[0] = nums[0];
        dp1[1] = Math.Max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i)
        {
            if (i == n - 1)
            {
                dp1[i] = dp1[i - 1];
                continue;
            }
            dp1[i] = Math.Max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }

        dp2[n - 1] = nums[n - 1];
        dp2[n - 2] = Math.Max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; --i)
        {
            if (i == 0)
            {
                dp2[i] = dp2[i + 1];
                continue;
            }
            dp2[i] = Math.Max(dp2[i + 1], nums[i] + dp2[i + 2]);
        }
        // Console.WriteLine($"dp1: {string.Join(",", dp1)}");
        // Console.WriteLine($"dp2: {string.Join(",", dp2)}");
        return Math.Max(dp1.Max(), dp2.Max());
    }
}

/*
either rob first or last house at the start

dp1[0] = nums[0]
dp1[1] = Max(dp[0],nums[1])
dp1[i] = Max(dp[i-1], nums[i] + dp[i-2])

dp2[0] = nums[last]
dp2[1] = nums[1] + dp[0]
dp2[i] = Max(dp[i-1], nums[i] + dp[i-2])

if we are at second to last house, dp2 cannot rob another house
if we are at last house, dp1 cannot rob another house

nums = [2,3,2]
            i
dp1  = [2,3,3]
dp2  = [2,2,2]

nums = [1,2,3,1]
              i
dp   = [1,2,4,4]

nums = [1,2,3]
          i
dp   = [3,3,3]

nums = [1,2,1,1] n=4
        0 1 2 3
              i
dp1  = [1,2,2,2] rob first house
dp2  = [1,3,3,3] rob last house
*/