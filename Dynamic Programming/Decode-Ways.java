class Solution {
    /*
    Understand
    Since this is a dp problem, how can we break it down to subproblems?
    "11106"
       i
     dp[1,2,]
    "1" - how many times can you group "1"? 1
    "11" - how many times can you group "11"? 2
    "111" - how many times can you group "111"? 3
    "1110" - how many times can you group "1110"? 2 (1-1-10 or 11-10)
    "11106"- how many times can you group "11106"? 
    This approach is prob not gonna work since there isn't a pattern as you add more characters
    
    "299"
      i
    num = "99"  the num 99 can still be decoded even though it's greater than 26 because we can do 9-9 which is "II" (I maps to 9)
    dp = [1,1,1,1]
          0 1 2 3
    answer: dp[3] = 1
    
    Match
    Dynamic Programming 
    
    Plan
    If the input starts with a 0, there's no way to deocode it so return 0
    Create a dp array to memoize ways to decode the substrings
    dp[i] equals the numbers of ways to decode the string up to the i^th letter of the string
    dp[0] = 1 b/c there's only 1 way to decode empty string
    dp[1] = 1 b/c there's inly 1 way to decode a single number
    from i = 1(second character) to the last character of the string
        we want to look at two numbers at a time
        leftDigit = s.charAt(i-1)      (this is the tens place)
        rightDigit = s.charAt(i)       (this is the ones place)
        check if rightDigit == '0'
            if the leftDigit == '1' OR '2'        (the number is either 10 or 20, so still valid) 
                dp[i + 1] = dp[i - 1]
            else 
                return 0 b/c the number is now invalid& cannot be decoded
        else
            if the number is between 10(inclusive) and 26(inclusive)
                dp[i + 1] = dp[i] + dp[i-1]
            else
                dp[i+1] = dp[i]
    return the last value in dp array
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        
        /* "11106"
       dp:[11____]              
        */
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < s.length(); ++i) {
            char leftDigit = s.charAt(i - 1);
            char rightDigit = s.charAt(i);
            if(rightDigit == '0') {
                if(leftDigit == '1' || leftDigit == '2') {
                    dp[i + 1] = dp[i - 1];
                }
                else {
                    return 0;
                }
            }
            else {
                int num = Integer.parseInt("" + leftDigit + rightDigit);
                if(10 <= num && num <= 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
                else {
                    dp[i + 1] = dp[i];
                }
            }
            
        }
        return dp[s.length()];
    }
}
