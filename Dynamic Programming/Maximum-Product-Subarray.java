class Solution {
    
    /*
    Understand
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
        Input: nums = [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.

    Match
    Dynamic Programming

    Plan
    Basically we want to traverse the list once and as we traverse, record the product as we go
    There's 3 variable we want to store: the maxProduct at the i'th index
                                         the minProduct at the i'th index
                                         the result (maximum product of the entire array)
                                         
    if the array contains only positive numbers then we can just continue multiplying numbers as we traverse and the product will get bigger
    if we run into a negative number that makes the product negative 
    however, two negatives makes the product positive, so that why we need to store the minProduct incase a double negative occurs which makes the product positive
    
    max = Math.max(nums[i], nums[i] * max, nums[i] * min)
    min = Math.min(nums[i], nums[i] * max, nums[i] * min)

    Evaluate
    Time: O(N)
    Space: O(1)
    */
    
    public int maxProduct(int[] nums) {
        
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; ++i) {
            int newMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int newMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
                
            max = newMax;
            min = newMin;
                
            result = Math.max(result, max);
        }
        
        return result;
    }
}
