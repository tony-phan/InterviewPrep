class Solution {
    /*
    circular property can be used to group 1's
    
    calculate total number of 1's = x
    x will be the size of the subarrays we check for
    check every subarray of size x 
    the number of 0's in the subarray is the number of swaps
    keep track of the minimum number of swaps as we go through each subarray

    */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }

        int numberOf1s = getNum1s(nums, 0, n - 1);
        int result = Integer.MAX_VALUE;
        int left = 0, right = numberOf1s - 1;
        int numSubarray1s = getNum1s(nums, left, right);
        while(left < n) {
            result = Math.min(result, numberOf1s - numSubarray1s);
            
            ++left;
            right = (right + 1) % n;
            if(nums[right] == 1) { // if the previous left was a 1, then decrement number of 1's in the subarray
                ++numSubarray1s;
            }
            if(left - 1 >= 0 && nums[left - 1] == 1) { // if the right pointer is pointing to a 1, increment number of 1's in the subarray
                --numSubarray1s;
            }
        }
        return result;
    }

    private int getNum1s(int[] nums, int left, int right) {
        int num1s = 0;
        for(int i = left; i <= right; ++i) {
            if(nums[i] == 1) {
                ++num1s;
            }
        } 
        return num1s;
    }
}
