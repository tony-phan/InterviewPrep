class Solution {
    
    /*
    s = "abcaa", t = "qweqq"
    output: true
    
    s = "aa", t = "aa"
    output: true
    
    s = "qwetic" t = "euionw"
        q - e
        w - u
        e - i
        t - o
        i - n
        c - w
    output: true
    
    s = "badc"
    t = "baba"
        b - b
        a - a
        d - b
        c - a
    
    Match
    hashmap: use to store the mapping from letters in "s" to letters in "t"
    
    Plan
    
    add mappings from letters in "s" with letters in "t"
        IMPORTANT: make sure that no two characters can map to the same character
    loop through both strings 
    for each letter we are at check for 2 things:
        the map contains a key for the current letter for "s"
        if yes, then check the mapping between letter in s and letter in t
        if the mapping does not match then return false
    

	Evaluate
	Time: O(n)
	Space: O(n)
    */
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        
        boolean result = true;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            if(!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        
        for(int i = 0; i < s.length(); ++i) {
            char letter_s = s.charAt(i), letter_t = t.charAt(i);
            if(!map.containsKey(letter_s) || map.get(letter_s) != letter_t) {
                result = false;
                break;
            }
        }
        return result;
    }
}
