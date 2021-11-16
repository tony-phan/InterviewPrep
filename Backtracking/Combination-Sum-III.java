class Solution {
    /*
    Understand
    We are given two int's as input k and n
    We want to find all valid combinations of k numbers that sum to n
    Restrictions: only digits 1 through 9 can be used
                  each # is used only once
                  cannot contain duplicate combinations
    Example:
    Input: k = 3, n = 9
    Output: [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
    1 + 2 + 6 = 9
    1 + 3 + 5 = 9
    2 + 3 + 4 = 9
    There are no other valid combinations.
    
    Match
    Backtracking - generate all combinations of k numbers that sum up to the value n
    Recursion
    
    Plan
    Create a list of lists to hold result
    call helper function 
        if the current combination size > k 
            return
        else if the combination size == k && n == 0
            add the combination to the result
            return
        for i = start to 9
            add i to the combination
            call helper again with start = i + 1 and n = n - i
            remove val i from combination
    return the result
    
    Evaluate
    Time: O(9^k) // there are a total of 9 digits to check with a size of k for each combination
    Space: O(k)
    */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int k, int n, int start, List<List<Integer>> result, List<Integer> combination) {
        if(combination.size() > k) {
            return;
        }
        else if(combination.size() == k && n == 0) {
            List<Integer> copy = new ArrayList<>(combination);
            result.add(copy);
            return;
        }
        
        for(int i = start; i < 10; ++i) {
            combination.add(i);
            backtrack(k, n - i, i + 1, result, combination);
            combination.remove(combination.size() - 1);         // this step is important in backtracking
        }
    }
}
