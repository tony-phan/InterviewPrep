class Solution {
    /*
    Understand 
    Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
    Example: Input: nums = [1,3,5,4,7]
             Output: 3
             Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
             Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element 4.

    Match
    Arrays
    
    Plan
    the idea is to traverse the array and compare every i'th & (i-1)'th position
    if (i-1) is less than i, increment the subsequence
    else, store the subsequence size to result and reset subsequence to 1
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int result = 0;
        int subsequence = 1;
        
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i - 1] < nums[i]) {
                ++subsequence;
            }
            else {
                result = Math.max(result, subsequence);
                subsequence = 1;
            }
        }
        result = Math.max(result, subsequence);
        
        return result;
    }
}
