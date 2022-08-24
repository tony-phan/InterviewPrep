class Solution {
    /*
    [0,1,2,3,4,2,2,3,3,4] -> [0,1,2,3,4,_,_,_,_,_]
             k     
                       i
                       
    [0,1,2,3,4,2,2,3,3,4]   
             l
                         r
    [1,2,2] 
       l
           r
    
    We will use two pointers to move all duplicates to the right of the list
    the left pointer will help us point to the index we want to move a unique number to
    the right pointer will look for unique numbers 
    
    if left == right, right the right pointer to look for a unique number
    if left != right, set nums[left + 1] = to right and increment left & right pointers
    */
    
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return 1;
        
        int left = 0, right = 1;
        
        while(right < nums.length) {
            if(nums[left] == nums[right]) {
                ++right;
            }
            else {
                nums[left + 1] = nums[right];
                ++left;
                ++right;
            }
        }
        return left + 1;
    }
}
