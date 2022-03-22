class Solution {
    /*
    words = ["dog","cat","monkey","dog","cat","monkey","lion"], k = 2
    output: ["cat","dog"]
    
    Match: use a hashmap to keep track of each words frequency
        maybe use some kind of data structure that can order the k most frequent words by lexicographical order
        using a heap
    
    Plan
        1.get the frequencies of all words and use a hashmap to store them
            dog - 2
            cat - 2
            monkey - 2
            lion - 1
        2.create a priority queue (minHeap) to order string based off their frequency & alphabetic order
            the priority queue will store words in reverse alphabetic order (will have to reverse result list later)
            the priority queue will store a max of k elements
        3.remove from the list and add to result list
        4. return the reversed list
            
    Evaluate
    Time: O(N * log(K)) 
          O(N) time to populate the hasmap and O(log(K)) time to insert elements into the heap
    Space: O(N)
    */
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null) {
            return null;
        }
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String word1, String word2) {
                if(map.get(word1) == map.get(word2)) {
                    return word2.compareTo(word1);
                }
                else {
                    if(map.get(word1) < map.get(word2)) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            }
        });       
        
        getWordFrequencies(map, words);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(entry.getKey());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private void getWordFrequencies(Map<String, Integer> map, String[] words) {
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}
