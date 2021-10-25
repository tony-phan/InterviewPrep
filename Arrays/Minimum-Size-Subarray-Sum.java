class Solution {
    /*
    Understand
    We are given an int array and a target as input
    We want to find the minimum length of a contigious subarray whose sum is greater than or equal to target
    EX: target = 7, nums = [2,3,1,2,4,3]
        Output = 2 (the subarray [4,3] has the minimal length under the problem constraint)
    
    Match
    Array problem
    Two pointer Pattern (Sliding Window) - can be applied because we are dealing with a contiguous subarray
    
    Plan
    Two Pointer Pattern
    Create a left and right pointer
    while both left and right pointers are less than array size
    as we move the left&right pointers keep a running sum of which values are in the subarray
    move the right pointer to the right until we hit or exceed the target sum
    update the minimum subarray length
    then move the left point to the right until the sum is less than the target
    move the right pointer again until we exceed the target sum
    move the left pointer as necessary to shrink the subarray
    keep doing this until the right pointer is at the end of the array
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int subarraySum = 0, left = 0, right = 0;
        
        while(right < nums.length) {
            subarraySum += nums[right];
            ++right;
            
            while(subarraySum >= target) {
                result = Math.min(result, right - left);
                subarraySum -= nums[left];
                ++left;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
