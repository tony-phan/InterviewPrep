class Solution {
    /*
    
    [1,0,3,12,0]
              l
                r
    
    [1,3,12,0,0]
            l
                r
    
    Two pointers: have a left pointer at the start, right pointer at start + 1
    increment the left pointer until it points to a 0
    increment the right pointer until it points to a nonzero
    swap left & right pointers
    by the end of this all 0's should be at the end
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        
        int left = 0, right = 1;
        
        while(right < nums.length) {
            if(nums[left] != 0) {
                ++left;
                ++right;
            }
            else if(nums[right] == 0) {
                ++right;
            }
            else {
                swap(nums, left, right);
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
