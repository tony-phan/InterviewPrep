class Solution {
    /*
    Understand
    input: string and list of words (dictionary)
    output: return true if the string 
    
    "code"   ["leet","code"]
     i                i
     
    "catsandog"  ["cats","dog","sand","and","cat"]
     i              i    
    
    "" - true                       ["a","b","c"]
    "a" - true if in dictionary?
    "ab" - "ab" is in dictionary or 'a' and 'b' are in dictionary    
    "abc" - "abc" is in dictionary OR 'ab'(*) + 'c' OR 'a'(*) + 'bc' OR 'a'(*),'b'(*),'c'
    
    "" - true                       ["a","b","c","d"]
    "a" - true
    "b" - true
    "ab" - false or 'a'(line 19, true) and true   - true
    "bc" - true
    "abc" - true
    
    start at 0, end at string length - 1
    
    "abc d"     condition: sum need to be bigger than one you're looking for
    T T
    
      0 1 2 3
    0 T T T T    
    1 F T
    2 F F T
    3 F F F T
    
    i   j
    1. fill table for single letters (i==j) directly check from dictionary
    2. j > i: find k^th position (between 0 and j - 1) to break string so that first substring is in the true is intable and j to second substring is in dictionary
    
    
    Match
    Dynamic Programming
    This solution is not dynamic programming, instead it is recursive solution with memoization
    
    Plan
    The idea of this solution is that for each word in the wordDict, does s have a prefix for that word, if yes then recursively call the same function on the suffix (part of the word after prefix) and check again if the modified word that a prefix in the wordDict. The entire solution would be true if we recurse down to the empty string
    Example: "applepenapple", wordDict = ["apple","pen"]
                                            i
            prefix: apple, suffix: penapple
                                  (recursively call on the suffix if it has a prefix in the dict)
            prefix: pen, suffix: apple
            prefix: apple, suffix: "" (empty string)
            prefix: "" return true
    
    Create a hashset to store all words in dict w/o duplicates
    Create a map to memoize results of substrings in the recursion
    
    if the s length == 0 return true
    if the map contains a key for s, return its value in the map
    
    loop through each word in the word dictionary
    if the words length is greater than s, continue
    get the prefix string of s by using the length of the current word in dict
    if the prefix equals the current dict word
        calculate the suffix
        recursively call the helper function on the suffix and store result in variable
        if the recursion evaluates to true
            update the map for the current suffix to true
            return true
        else
            update the map for the current suffix to false
    return false
    
    Evaluate
    Time: O(N^2)
    Space: O(N)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, set, map);
    }
    
    private boolean helper(String s, Set<String> set, Map<String, Boolean> map) {
        if(s.length() == 0) {
            return true;
        }
        else if(map.containsKey(s)) {
            return map.get(s);
        }
        
        for(String word : set) {
            if(word.length() > s.length()) {
                continue;
            }
            String prefix = s.substring(0, word.length());
            if(prefix.equals(word)) {
                String suffix = s.substring(word.length());
                boolean validate = helper(suffix, set, map);
                if(validate) {
                    map.put(suffix, true);
                    return true;
                }
                else {
                    map.put(suffix, false);
                }
            }
        }
        return false;
    }
}
