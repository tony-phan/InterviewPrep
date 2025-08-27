public class Solution
{
    public int LengthOfLIS(int[] nums)
    {
        int n = nums.Length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; ++i)
        {
            int currentVal = nums[i];
            int sequenceLength = 1;
            for (int j = 0; j < i; ++j)
            {
                if (nums[j] < nums[i])
                {
                    sequenceLength = Math.Max(sequenceLength, 1 + dp[j]);
                }
            }
            dp[i] = sequenceLength;
        }

        return dp.Max();
    }
}

/*
nums = [10,9,2,5,3,7,101,18]
                          i
dp =   [ 1,1,1,2,2,3,  1, 4]

currentVal = 5
sequenceLength = 4
for j=0 to j<i
    if nums[j] < nums[i]
        sequenceLength = Math.Max(sequenceLength, 1 + dp[j]) 
dp[i] = sequenceLength

return dp[last]

nums = [1,3,6,7,9,4,10,5,6]
dp   = [1,2,3,4,5,3, 6,4,5]


                  i
dp   = [1,2,1,3,3,]

currentVal = 3
sequenceLength = 4
*/