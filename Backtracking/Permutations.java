class Solution {
    /*
    Understand
    We are given an int array of distinct numbers
    Return all possible permutations of the int array
    
    Example: nums = [1,2,3]
             output = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
             
             Start: [1] -> [1,2] -> [1,2,3] -> [1,2] ->
                    [1] -> [1,3] -> [1,3,2] -> [1,3] ->
                    [1] -> [] -> [2] -> [2,1] -> [2,1,3] ->
                    ...
    We can use backtracking to go back one step after we've found a permutation to find other permutations
    Example: permutation = [1,2,3], nums = [1,2,3]
             backtrack(remove 3) -> [1,2] -> backtrack(remove 2) -> [1] -> [1,3] -> [1,3,2] -> backtrack(remove2) -> [                [1,3] -> ....
    
    Match
    Backtracking
    Recursion
    
    Plan
    Create a list of lists to store the result
    call the backtrack helper function
        if the current permutation size == num length
            add the permutation to the result
            return
        for i = 0 to last num in nums
            if the current permutation contains nums[i]
                skip that num and continue to next iteration
            add the num into permutations
            recursively call backtrack function on the current permutation
            remove the num fronm permutations
    return the result
    
    Evaluate
    Time: O(N! * N)
    Space: O(N)
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> permutation) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i) {
            if(permutation.contains(nums[i])) { // we want to skip nums that we already have in the permutation
                continue;
            }
            permutation.add(nums[i]);
            backtrack(nums, result, permutation);
            permutation.remove(permutation.size() - 1);     // IMPORTANT step
        }
    }
}
