class Solution {
    /*
    We only care about ordering by frequency, not ordering by alphabetic
    
    Understand:
    s = "1popp1a"
    output = "oa11ppp"
    
    Match
    Hashmap: used to map each character/digit to its frequency
    Heap: order each unique letter/digit based off its frequency
    
    Plan:
    map each letter/digit to its frequency in the hashmap
    key each key in the hashmap, add it to the heap
    construct the result string
        poll a character from the heap
        get the character's frequency from the hashmap
        use a for loop to add the character to the result x times (x = frequency)
    return the result string
    
    Evaluate
    Time: O(nlog(n))
    Space: O(n)
    */
    public String frequencySort(String s) {
        if(s == null) {
            return null;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if(map.get(c1) == map.get(c2)) {
                    return c1.compareTo(c2);
                }
                else if(map.get(c1) > map.get(c2)) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        
        getFrequencies(map, s);
        for(Character c : map.keySet()) {
            heap.add(c);
        }
        
        String result = "";
        while(!heap.isEmpty()) {
            Character c = heap.poll();
            int count = map.get(c);
            
            for(int i = 0; i < count; ++i) {
                result += c;
            }
        }
        
        return result;
    }
    private void getFrequencies(Map<Character, Integer> map, String s) {
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
}
