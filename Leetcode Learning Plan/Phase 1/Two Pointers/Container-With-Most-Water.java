class Solution {
    
    /*
    
    [1,8,6,2,5,4,8,3,7]
     l                
                     r
    
    We'll use two pointers to solve this
    Basically we can find the maximum water amount by calculating the water amount between left & right pointer, and storing the maximum as we continue to iterate
    the tricky part is knowing when to update left & right pointer: 
        if right < left, update right
        if left < right, update left
    
    
    start left at index 0 and right at the last index
    calculate the amount of water between left & right
        water = Math.min(height[left], height[right]) * (right - left);
    store the maximum amount of water
    update either the left or right pointer
    
    Evaluate
    Time: O(N)
    Space: O(1)
    */
    
    public int maxArea(int[] height) {
        int result = 0;
        int n = height.length;
        
        int left = 0, right = n - 1;
        while(left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, water);
            
            if(height[left] <= height[right]) {
                ++left;
            }
            else {
                --right;
            }
        }

        return result;
    }
}
