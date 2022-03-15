class Solution {
    /*
    Understand
    Given an input string s, reverse the order of the words.

    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

    Return a string of the words in reverse order concatenated by a single space.
    
    Examples: Input: s = "the sky is blue"
              Output: "blue is sky the"
              
              Input: s = "a good   example"
              Output: "example good a"
    
    Match
    String problem
    
    Plan
    First trim leading and trailing whitespaces
    Then go through each character in the string
    if the char is not whitespace, add it to a string variable to store the current word
    if the char is whitespace
        check that the current word is not empty
            if yes, add it to the deque and reset the string variable for the current word
    remove the items from the deque starting from the front
    return the result
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public String reverseWords(String s) {
        s = s.trim();               // get rid of leading and trailing whitespace
        
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        
        int left = 0, right = s.length() - 1;
        while(left <= right) {     
            char c = s.charAt(left);
            if(c != ' ') {          // if the current character is not whitespace
                word.append(c);
            }                       // if the current character is whitespace
            else {
                if(word.length() != 0) { // if the current word is a word, add it to the deque (this conditional will skip consecutive whitespaces)
                    deque.offerFirst(word.toString());
                    word.setLength(0);
                }
            }
            ++left;
        }
        deque.offerFirst(word.toString()); // add the last word to the deque
        word.setLength(0);
        
        while(!deque.isEmpty()) {
            if(deque.size() == 1) {
                word.append(deque.pollFirst());
            }
            else {
                word.append(deque.pollFirst() + " ");
            }
        }
        return word.toString();
    }
}
