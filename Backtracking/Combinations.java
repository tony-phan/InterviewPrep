class Solution {
    /*
    Understand
    We are given two int's as input: n and k
    we want to generate all combinations on numbers in the range of 1 to n that are of size k
    Example: n = 4, k =2
             output: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
             
             k = 2, n = 4
             [1,2,3,4] 
             Order of combinations generated: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    
    Match
    Backtracking - we basically want to generate all combinations of numbers in the range [1,n] that are of size = k 
    Recursion
    
    Plan
    Create a list of lists to hold the result
    call the backtrack helper function on the result to generate all combinations with start value at 1
        if the current combination's size > k
            return
        if the current combination's size == k
            add the combination to the result
            return
        for i = startValue to n
            add i to the combination
            recursively call backtrack on current combination with startval += 1
            remove i from the combination
    return the result
    
    Evaluate
    Time: O(n!)
    Space: O(n)
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }
    
    private void backtrack(int n, int k, List<List<Integer>> result, List<Integer> combination, int startValue) {
        if(combination.size() > k) {
            return;
        }
        else if(combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = startValue; i <= n; ++i) {
            combination.add(i);
            backtrack(n, k, result, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
