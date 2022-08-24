class Solution {
    /*     
     [0,0,1,1,2,3,3,3,3] -> [0,0,1,1,2,3,3,_,_]
                  k
                        i
    
    occurance = 1
    
    if nums[i] == nums[k] && numOccurance < 2  - swap k + 1 & i, numOccurance + 1, 
    else if nums[i] == nums[k] && numOccurance == 2 - increment i until you find a non duplicate (continue)
    else if nums[i] != nums[k] && numOccurance < 2 - swap k + 1 & i, numOccurance = 1
    else if nums[i] != nums[k] && numOccurance == 2 - swap k + 1 & i, numOccurances = 1
    
    This is similar to leetcode #26 (Remove Duplicates from Sorted Array) where we use two pointers in the same way
    left pointer will help us point to the location to swap a unique element
    right pointer will help us find a unique number down the list
    we will use a counter (named: occurance) to keep track off how many occurances of the unique element left pointer is at (each unique element appears at most twice)
    
    if left == right && occurance < 2 then left+1 = right, occurance += 1
    if left == right && occurance == 2 then right += 1, continue to next loop iteration
    if left != right then left+1 = right, occurance = 1
    increment left & right pointer before looping again
    
    return left + 1
    
    Evaluate
    Time: O(N)
    Space: O(1)
    
    */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return 1;
        
        int left = 0, right = 1, n = nums.length, occurances = 1;
        
        while(right < n) {
            if(nums[left] == nums[right]) {
                if(occurances < 2) {
                    nums[left + 1] = nums[right];
                    ++occurances;
                }
                else {
                    ++right;
                    continue;
                }
            }
            else {
                nums[left + 1] = nums[right];
                occurances = 1;
            }
            ++left;
            ++right;
        }
        
        return left + 1;
    }
}
