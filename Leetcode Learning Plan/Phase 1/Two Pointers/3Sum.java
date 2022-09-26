class Solution {
    /*
    We will use 2pointer to solve this problem
    First sort the array
    
    To come up with generating triplets, we will have a i'th pointer (starting at index 0), leftPointer (starting at index i + 1), and rightPointer (starting at N - 1)
    if the sum of the three pointer is 0, then store that triplet
    otherwise, update the left or right pointer
    
    if the sum is less than 0, increment left pointer so the sum increases
    if the sum is greater than 0, decrement the right pointer so the sum decreases
    (essentially, we want to update the pointer in such a way that the sum gets closer to 0)
    
    be careful for duplicate values so that you don't have duplicate triplets!
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {
                    ++left;
                }
                else if(sum > 0) {
                    --right;
                }
                else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    
                    while(left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    ++left;
                    
                    while(left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    --right;
                }
            }
        }
        return result;
    }
}
