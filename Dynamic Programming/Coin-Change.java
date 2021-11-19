class Solution {
    /*
    Understand
    we can use a dp array to store the minimum num of coins are some amount i
    dp[0] = min num of coins for amount 0, we always know dp[0] is 0
    dp[n] = min num of coins for amount n
    
    for each amount i, we want to get the minimum between dp[i] and dp[i - coin]+1
    dp[i]'s answer takes into consideration previous answers (dp[i] could have its answer come from dp[i-1] or dp[i-2])
    
    Match
    Backtracking
    
    Plan
    if the amount == 0
        return 0
    create a dp array of size amount+1 to store all subproblem solutions 
    fill the dp array with the value amount+1
    set dp[0] = 0
    for i = 1 to last index in dp
        for coin in coins
            if coin > 1
                continue
            dp[i] = min(dp[i], dp[i - coin] + 1)
    if dp[amount] == amount+1 return -1
    else return dp[amount]
    
    Evaluate
    Time: O(N*amount)
    Space: O(amount)
    */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i < dp.length; ++i) {
            for(int coin : coins) {
                if(coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
