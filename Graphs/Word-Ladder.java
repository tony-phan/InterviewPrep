class Solution {
    /*
    Understand
    beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    hit -> cog
    hit -> hot -> dot -> dog -> cog
    1. We need to replace a single letter for each adjacent word, not append/delete
    2. length of begin and end word is the same
    
    Match
    BFS, String pattern matching, Set<> -> visited word
    
    Map<String, List<String>> adjacency list
    
    hit
    #it -> 
    h#t -> hot
    hi# -> 
    
    hot
    #ot -> dot, lot
    h#t -> 
    ho# -> 
    
    dot
    #ot ->
    d#t -> 
    do# -> dog
    
    lot
    #ot -> 
    l#t -> 
    lo# -> log
    
    cog
    count++
    
    Evaluate:
    Time: O(N*M)
            N: # of words
            M: length of each word
    Space: O(N * M^2)
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for(String word : wordList) {
            for(int i = 0; i < word.length(); ++i) {
                String wordPattern = word.substring(0, i) + "#" + word.substring(i + 1); // hit -> "#it", "h#t", "hi#"
                
                if(map.containsKey(wordPattern)) {
                    (map.get(wordPattern)).add(word);
                }
                else {
                    map.put(wordPattern, new ArrayList<>());
                    (map.get(wordPattern)).add(word);
                }
            }
        }
        
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; ++i) {
                String word = queue.poll();
                for(int j = 0; j < word.length(); ++j) {
                    String wordPattern = word.substring(0, j) + "#" + word.substring(j + 1);
                    if(map.containsKey(wordPattern)) {
                        List<String> wordsList = map.get(wordPattern);
                        for(String w : wordsList) {
                            if(!visited.contains(w)) {
                                if(w.equals(endWord)) {
                                    return result + 1;
                                }
                                else {
                                    visited.add(w);
                                    queue.add(w);
                                }
                            }
                        }
                    }
                }
            }
            ++result;
        }
        return 0;
    }
}
