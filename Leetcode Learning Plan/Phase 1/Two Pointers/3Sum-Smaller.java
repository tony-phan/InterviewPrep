class Solution {
    /*
    We will use two pointers to solve this
    Similar to 3sum we will sort the array and use two pointers to generate triplets
    
    for each triplet we generate, calculate the sum 
    if the sum < target then then all the values between left & right pointer will also have a sum less than sum.
    result += (right - left)
    increment left pointer
    
    if the sum > target: decrement right pointer
    
    for some reason this method will ensure that no duplicate triplets will not be accoutned for so it works somehow
    
    Time: O(n^2)
    Space: O(1)
    */
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;    
        }
        
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 2; ++i) {            
            int left = i + 1, right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    result += (right - left);
                    ++left;
                }
                else {
                    --right;   
                }
            }
        }
        return result;
    }
}
