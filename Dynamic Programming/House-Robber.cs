public class Solution {
    public int Rob(int[] nums) {
        int n = nums.Length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.Max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.Max(nums[0], nums[1]);

        for(int i = 2; i < n; ++i) {
            int maxAmountRobbed = Math.Max(nums[i] + dp[i-2], dp[i-1]);
            dp[i] = maxAmountRobbed;
        }
        return dp[n-1];
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