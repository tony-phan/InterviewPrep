class Solution {
    /*
    Understand 
    We are given an array of strings and we want to group all strings that are anagrams
    Return a list of lists of strings where each list is a group of anagrams
    
    Example: Input = ["eat","tea","tan","ate","nat","bat"]
             Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Note: what if there are duplicate strings? 
    Observation: If a two words are anagrams, then if you sort both words the sorted words will be the same
                 Example: "eat" and "tea"
                            |  (sort) |
                           "aet"     "aet"
    
    Match
    Array & String problem
    
    Plan
    Use a hashmap to store all anagrams
        the key will be the sorted string of the anagrams (all anagram will share the same sorted string)
        loop through the list of words
        sort the word
        if the map does not contain the sorted word as a key
            add it to the map
        add the current word to the list of anagrams for the current key
    Loop through the hashmap and add all the values into the result list
    return result list
    
    Evaluate
    Time: O(N * Mlog(M))
    Space: O(N)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            (map.get(sorted)).add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
