    /*
    Understand
    Since this is a rotated array , we have to do a modified binary search
    Essentially we want to find the pivot of the array (where val[i - 1] > val[i])
    when to search in right half: if the middle value is greater than value at left index and greater than value at right index
        why? because the middle value should be greater than all values to the left and less than all values to the right
        if this is false then we can deduce that the minimum val is in the right half
    when to search in left half: if the middle value is less than value at right index and less than value at the left index
        why? because the middle value should be less than all values to the right and greater than all values to the left
             if this is false then we can deduce that the minimum val is in the left half
    
    Match
    Array Problem
    Binary Search
    
    Plan
    We want to do a modified binary search
    for each middle value we're at, compare it to it's previous
        if the previous val is greater than current, then the min value is at middle so return middle value
        
        if the middle value is greater than left value and greater than right value, then we for sure know the minimum val is in the right half so update the left index value
        else search the left half by updating the right index value
    by the end if we aren't able to find the minimum value through middle, then we know the left index value is the minimum so return it
    
    Evaluate
    Time: O(log(N))
    Space: O(1)
    */
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int middle = left + (right - left)/2;
            if(middle > 0 && nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
            
            if(nums[left] <= nums[middle] && nums[middle] > nums[right]) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return nums[left];
    }
}
