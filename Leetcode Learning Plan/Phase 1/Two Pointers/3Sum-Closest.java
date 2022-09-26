class Solution {
    /*
    this problem is similar to 3sum (leetcode #15) and borrows similar logic
    
    we borrow the same idea from 3sum by using the two pointer method to get a triplet 
    calculate the sum for each triplet and find the difference with the target
    store the sum that is closest to the target value (basically, find the minimum)
    
    the tricky part is knowing when to update the left or right pointer
    if the current sum is less than the target then update the left pointer to make the sum larger
    if the current sum is greater than the target then update the right pointer to make the sum smaller
    */
    
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int minDifference = Integer.MAX_VALUE;
        int n = nums.length;
        
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; ++i) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            
            int left = i + 1, right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int difference = Math.abs(sum - target);
                if(difference < minDifference) {
                    minDifference = difference;
                    result = sum;
                }
                
                if(sum == target) {
                    return result;
                }
                else if(sum < target) {
                    while(left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    ++left;
                }
                else {
                    while(left < right && nums[right - 1] == nums[right]) {
                        --right;
                    }
                    --right;
                }
            }
        }
        return result;
    }
}
