class Solution {
    /*
    Data Structure Used: Set
    
    jewels = "" stones = "A"
    output = 1
    
    each character in jewels represents a jewel
    
    Match
    Hashmap: can be used to store the distinct jewels 
    
    Plan
    store the distinct jewels in the hashmap
    go through each stone in stones, and check if the hashmap contains a key for the stone we're at 
    
    Evaluate
    Time: O(n)
    Space: O(n)
    
    */
    
    public int numJewelsInStones(String jewels, String stones) {
        if(jewels == null || stones == null) {
            return 0;
        }
        
        int result = 0;
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < jewels.length(); ++i) {
            set.add(jewels.charAt(i));
        }
        
        for(int i = 0; i < stones.length(); ++i) {
            char stone = stones.charAt(i);
            
            if(set.contains(stone)) {
                ++result;
            }
        }
        
        return result;
    }
}
