class Solution {
    /*
    Understand
    We are given an input array (arr) containing strings
    Find the length of the longest subsequence of the strings in arr that has unique characters
    
    Subsequence of an array: an array formed by deleting some or no elements without changing the order of the remaining elements
    
    Example: arr = ["un","iq","ue"]
             output = 4 (longest unique subsequence = "uniq" or "ique")
             
             Subsequences of arr: "", "un", "uniq", "ique" 
                                  "iqun" is not valid b/c the order is broken
    
    Match
    This is a backtracking and array problem so recursion is involved

    Plan
    Generate all subsequences of the input array and store the maximum possible length of all the unique subsequences
    
    base case: if the index is greater than the arr size or if the subsequence is not unique
    
    update the max subsequence length
    store the current subsequence to use for backtracking (temp)
    for(i = index; i < arr size; ++i) {
        subsequence += arr.get(i)
        backtrack(arr, subsequence, i + 1)
        subsequence = temp     (backtracking step)
    }

    Evaluate
    Time: O(n * 2^n)
    Space: O(n * 2^n)
    */
    
    int result = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);
        return result;
    }
    
    private void backtrack(List<String> arr, String s, int index) {
        if(index > arr.size() || !isUnique(s)) {  
            return;
        }
        
        result = Math.max(result, s.length());
        String temp = s;
        for(int i = index; i < arr.size(); ++i) {
            s += arr.get(i);
            backtrack(arr, s, i + 1);
            s = temp;
        }
    }
    
    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for(char letter : s.toCharArray()) {
            if(set.contains(letter)) {
                return false;
            }
            set.add(letter);
        }
        return true;
    }
}
