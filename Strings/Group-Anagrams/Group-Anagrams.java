class Solution {
    /*
    Understand 
    We are given an array of strings and we want to group all strings that are anagrams
    Return a list of lists of strings where each list is a group of anagrams
    
    Example: Input = ["eat","tea","tan","ate","nat","bat"]
             Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Note: what if there are duplicate strings? 
    
    Match
    Array & String problem
    
    Plan
    Create a set to store all words we've seen
    loop through each word in the array
    if we've already seen the word we're currently at continue to next word
    initialize a list to store the anagram group and add the current word into the list and into the set
    for each word ahead in the list
        check if both words are anagrams(*) (if yes add that word into the list and set)
    at the end of the inner for loop add the list into the result list
    return the result list
    
    (*)how to check if two strings are anagrams
        1. if the string lengths are different return false
        2. convert both strings into char arrays and sort them
        3. compare the contents of the sorted char arrays
        4. return true if the contents are the same and false otherwise
    
    Evaluate
    Time: O(N^2 * Nlog(N))
    Space: O(N)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < strs.length; ++i) {
            if(set.contains(strs[i])) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            set.add(strs[i]);
            for(int j = i; j < strs.length; ++j) {
                if(j == i) {
                    continue;
                }
                
                if(isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    set.add(strs[j]);
                }
            }
            result.add(group);
        }
        return result;
    }
    private boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        
        Arrays.sort(aArray);
        Arrays.sort(bArray);
        
        return Arrays.equals(aArray, bArray);
    }
}
