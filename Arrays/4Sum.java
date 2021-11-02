class Solution {
    /*
    Understand
    We are given an int array and a target as input
    We want to return all the unqiue quadruplets in the array such that their sum == target
    
    Example: [1,0,-1,0,-2,2], target = 0
             Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
             
    Match
    Array problem
    Extension of 3Sum problem?
    
    Plan
    Brute force: generate all quadruplets in the array and check if their sum == target
    
    Better solution:
    First sort the array
    Loop through each element in the array until we've reached 4th to last element
    if the index is greater than 0 and the value is equal to val at position - 1, continue 
    the new target value is target - current value
    perform the 3Sum problem algorithm on the new target value
    
    [2,2,2,2,2] -> [2,2,2,2,2]
    target = 8
    
    
    Evaluate
    Time: O(N^3)
    Space: O(N)
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int newTarget = target - nums[i];
            for(int j = i + 1; j < nums.length - 2; ++j) { // this is a repeat of 3Sum
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while(left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if(sum < newTarget) {
                        ++left;
                    }
                    else if(sum > newTarget) {
                        --right;
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
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
        }
        return result;
    }
}
