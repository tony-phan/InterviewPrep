class Solution {
    /*
    Understand
    We are given two strings as input: ransomNote and magazine
    We want to return true if we can contruct ransomNote from magazine (if magazine contains the characters that ransomNote has and at the same frequency)
    
    Example: ransomNote = "aa", magazine = "aab"
             Output: True (to construct ransomNote you need 2 'a's and magazine has 2 'a's)
    Map
    'a': 2
    'b': 1
    
    
    Match
    String problem
    Hashmap: can be used to store magazine's char's as keys and their frequencies as values
    
    Plan
    Use a hashmap to map magazine's characters and their frequencies
    Loop through each char in ransomNote
    if magazine does not have the character
        return false
    if magazine does have the character
        if the character frequency is 0
            we dont have enough characters in magazine so return false
        else
            subtract 1 from the frequency
    return true at the end of the loop because that means we can construct ransomNote
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c)) {
                return false;
            }
            else {
                if(map.get(c) == 0) {
                    return false;
                }
                else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return true;
    }
}
