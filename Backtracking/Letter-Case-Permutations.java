class Solution {
    /*
    Understand
    We are given a string s as input
    We can transform all letter individually to be upper/lower case to create another string
    return a list of all possible string we can create
    
    Example: s = "a1b2"
             output = ["a1b2","a1B2","A1b2","A1B2"]

            a1b2   i=0, when it's at a, since it's a letter, we have two branches: a, A
         /        \
       a1b2       A1b2 i=1 when it's at 1, we only have 1 branch which is itself
        |          |   
       a1b2       A1b2 i=2 when it's at b, we have two branches: b, B
       /  \        / \
      a1b2 a1B2  A1b2 A1B2 i=3  when it's at 2, we only have one branch.
       |    |     |     |
      a1b2 a1B2  A1b2  A1B2 i=4 = S.length(). End recursion, add permutation to ans. 
      
      During this process, we are changing the S char array itself
    
    Match
    Backtracking? tbh this is not really a backtracking problem, it's more of a dfs string problem
    
    Plan
    create a string list to store the result
    call the helper function with start index at 0 and convert the string as char array as arguments
        if the startindex > s.length
            return
        else if the start index == s.length
            add the string into the result list
            return
        
        if the current at startindex is a digit
            call helper with startIndex += 1
        else
            set letter at startIndex to lowercase
            call helper with startIndex += 1
            set letter at startIndex to uppercase
            call helper with startInde += 1
    return the result
    
    Evaluate
    Time: O(2^n)
    Space: O(2^n)
    */
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s.toCharArray(), result, 0);
        return result;
    }
    
    private void helper(char[] s, List<String> result, int startIndex) {
        if(startIndex > s.length) {
            return;
        }
        else if(startIndex == s.length) {
            result.add(new String(s));
            return;
        }
        
        char c = s[startIndex];
        if(Character.isDigit(c)) {
            helper(s, result, startIndex + 1);
        }
        else {
            s[startIndex] = Character.toLowerCase(c);
            helper(s, result, startIndex + 1);
            s[startIndex] = Character.toUpperCase(c);
            helper(s, result, startIndex + 1);
        }
    }
}
