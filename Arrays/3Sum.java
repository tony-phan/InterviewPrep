class Solution {
    /*
    Understand
    We are given an int array as input
    and we want to find all the triplets in the array whose sum is 0
    for each triplet (i,j,k), i != j and i != k and k != j
    
    Example: [-1,0,1,2,-1,-4]
             Output: [[-1,-1,2],[-1,0,1]]
    
    Match
    Array problem
    Two pointer approach can be used
    As well as sorting the list can help
    
    Plan
    Brute force: generate every triplet in the list and check its sum
    
    Optimal: First sort the input list
             Loop from first element to third to last element (i to i - 2)
             if the current element is the same valueas the previous element
             continue b/c we don't want to add duplicate triplets 
             For each iteration use two pointer technique by having one pointer at i+1 and another pointer to the last element
             calculate the sum
             if the sum is less than 0, move left pointer to right by 1
             if the sum is greater than 0, move right pointer to left by 1
             if the sum == 0, add the triplet into the result list
                update the left and right pointer to skip duplicates
             repeat this until done looping through the entire list
             
             [-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
                                         i j k
    
    Evaluate
    Time: O(N^2)
    Space: O(N)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        
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
                    while(left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                }
            }
        }
        return result;
    }
}
