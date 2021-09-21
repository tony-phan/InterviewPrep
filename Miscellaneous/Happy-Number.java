class Solution {
    /*
    Data Structure Used: HashSet
    
    n = 6
    6^2 = 36
    3^2 + 6^2 = 45
    4^2 + 5^2 = 41
    4^2 + 1^2 = 16
    1^2 + 6^2 = 37
    we could possibly be in a cycle
    
    Plan
    We can use a set to store sums we have calculated previously
    calculate the number's sum of squared digits, check if that is == 1
    if yes, the number is a happy number and we are done
    if no, check if the set contains the sum
        if yes, the number is not a happy number and we are done
        if no, add the sum to the set, make n = sum and continue on
        
    Evaluate
    Space: O(log(n))
    Time: O(log(n))
    */
    public boolean isHappy(int n) {
        boolean result = false;
        
        Set<Integer> set = new HashSet<>();
        while(true) {
            int squaredSum = getSumOfSquaredDigits(n);
            if(squaredSum == 1) {
                result = true;
                break;
            }
            
            if(!set.contains(squaredSum)) {
                set.add(squaredSum);
                n = squaredSum;
            }
            else {
                break;
            }
        }
        return result;
    }
    
    private int getSumOfSquaredDigits(int n) {
        if(n <= 0) {
            return 0;
        }
        
        return (int)Math.pow(n % 10, 2) + getSumOfSquaredDigits(n / 10);
    }
}
