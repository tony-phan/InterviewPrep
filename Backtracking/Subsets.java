class Solution {
    /*
    Power set: all possible subsets of a set
               subset: a set of any values from a set
               
               nums = [1,2,3]
               [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]

main {
    for(i = 0 to nums.length) {
        backtrack(subset, length, result)
    }
    return result;
}

backtrack(length, subset, result) {
    if(subset.size == length) {
        result.add(subset);
        return
    }
    
    for i = 0 to length - 1
    add nums[i] to subset
    backtrack(subset, length, result)
    remove nums[i] from subset
}

[1,2,3]
    Evaluate
    Time: O(N*N!)
    Space: O(N)
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i <= nums.length; ++i) {
            backtrack(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int size, int startIndex) {
        if(subset.size() == size) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i = startIndex; i < nums.length; ++i) {
            subset.add(nums[i]);
            backtrack(result, subset, nums, size, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
