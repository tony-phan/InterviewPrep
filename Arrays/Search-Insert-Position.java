class Solution {
    /*
    Understand
    We are given a target and a sorted int array
    We want to return the index of the target in the array, if the target is not found then return which index it should be inserted into
    1,3,5,6     target: 7
    Output: 4 (the target is not in the array, but it would be inserted into index 4)
    
    Match 
    Search Problem - binary search
    
    Plan
    Perform a binary search on the array to check the index where target is
    If the target is not in the list, we would return the index position of left because at the end of binary search, left position we be where we would insert target
    
    Evaluate
    Time: O(log(N))
    Space: O(1)
    */
    public int searchInsert(int[] nums, int target) {
        // edge case
        int first = nums[0], last = nums[nums.length - 1];
        // if the target is less than first element then insert at index 0
        if(target < first) {
            return 0;
        }
        // if the target is greater than the last element then insert at the last index
        if(target > last) {
            return nums.length;
        }
        
        int result = -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int middle = (left + right)/2;
            if(nums[middle] == target) {
                result = middle;
                break;
            }
            else if(nums[middle] > target) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        // if the target is not in the array
        if(result == -1) {
            // we use left index because binary search ends when left > right, if that's the case left's index position is where we would be where we would insert target (idk why this works exactly but it just does)
            result = left;
        }
        return result;
    }
}
