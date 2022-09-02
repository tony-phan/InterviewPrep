class Solution {
    /*
    
    We're going to use two pointers to solve this 
    This is a variant of the merge two sorted lists problem
    
    Basically, if the input has no negative numbers, then we start at the beginning of nums b/c the lowest # will be at index 0
    if there are negative numbers, then we want to find the first positive val in nums (that will be our starting point)
    
    left pointer will point to startIndex - 1 & right pointer will point to startindex
    if nums[left] <= nums[right] 
        add value at left to result and update left pointer
    if nums[right] < nums[left] 
        add value at right to result and update right pointer
        
    keep doing this as long as left >= 0 & right < nums.length
    
    Evaluate
    Time: O(n)
    Space: O(n)
    
    
    */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int startIndex = 0;
        for(int i = 0; i < n; ++i) {
            if(nums[startIndex] >= 0) {
                break;
            }
            ++startIndex;
        }
        
        int left = startIndex - 1, right = startIndex;
        int index = 0;
        
        while(0 <= left && right < n) {
            int leftSquare = (int)Math.pow(nums[left], 2);
            int rightSquare = (int)Math.pow(nums[right], 2);
            
            if(leftSquare <= rightSquare) {
                result[index] = leftSquare;
                ++index;
                --left;
            }
            else {
                result[index] = rightSquare;
                ++index;
                ++right;
            }
        }
        
        while(left >= 0) {
            int leftSquare = (int)Math.pow(nums[left], 2);
            result[index] = leftSquare;
            ++index;
            --left;
        }
        
        while(right < n) {
            int rightSquare = (int)Math.pow(nums[right], 2);
            result[index] = rightSquare;
            ++index;
            ++right;
        }
        
        return result;
    }
}
