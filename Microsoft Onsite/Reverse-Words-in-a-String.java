class Solution {
    /*
    Understand
    input is a string "s"
    "s" can contain alphabetic letters, digits, and whitespace
    Given an input string s, reverse the order of the words.
    s can contain leading and trailing whitespace or multple whitespace between two words
    
    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"
    
    Example 2:
    Input: s = "a good   example"
    Output: "example good a"
    
    Match
    String problem
    Will have to use a stack/deque to reverse the word order
    
    Plan
    first, trim the leading and trailing whitespace
    we want to go through each character in the string
    when we hit a whitespace then we've finished reading a word, and then store that word in a stack
    be carefull for multiple whitespaces between words
    once we are done going through all characters, pop from the stack into a result string
    return that string
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    
    public String reverseWords(String s) {
        String result = "";
        
        s = s.trim();
        Deque<String> deque = new ArrayDeque<>();
        String currentWord = "";
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c != ' ') {
                currentWord += c;
            }
            else {
                if(!currentWord.equals("")) {
                    deque.offerFirst(currentWord);
                    currentWord = "";
                }
            }
        }
        deque.offerFirst(currentWord);
        
        while(!deque.isEmpty()) {
            if(deque.size() == 1) {
                result += deque.pollFirst();
            }
            else {
                result += (deque.pollFirst() + " ");
            }
        }
        return result;
    }
}
