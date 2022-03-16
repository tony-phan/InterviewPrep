class Solution {
    /*
    Understand
    We are given an integer x as input
    we want to reverse x. If reversing x causes the value to go outside [-2^31, 2^31 - 1], return 0
    Example 1:
    Input: x = 123
    Output: 321
    
    Example 2:
    Input: x = -123
    Output: -321

    Match
    Math problem
    
    Plan
    How to reverse an integer: 
        1. grab the ones place: onesPlace = x % 10
        2. reduce the original number: x /= 10
        3. add onesPlace to the result: result = (result * 10) + onesPlace
    
    How to check if reversing x will cause underflow/overflow
    Overflow: 
    if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && onesPlace > 7)
        OR
    if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && onesPlace < -8)
    
    Evaluate
    Time: O(log(x))
    Space: O(1)
    */
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int onesPlace = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && onesPlace > 7)) {
                return 0;
            }
            else if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && onesPlace < -8)) {
                return 0;
            }
            result = (result * 10) + onesPlace;
        }
        return result;
    }
}
