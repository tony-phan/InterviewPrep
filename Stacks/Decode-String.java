class Solution {
    /*
    Understand
    s = "10[a]bc3[q]"
    output = "aaaaaaaaaabcqqq"
    
    Match
    Stack: stacks can be used to keep track of which digits and letters we've seen so far
           there can be numbers with more than two digits (i.e 12)
    Plan
    Create two stacks: one for storing the k of the encoded string and another for storing the prefix of that encoded string
    Loop through the string
        if the char is a digit
            add it to a string storing the number we're current at (number could have more than 1 digit)
        if the char is a letter
            add it to a string storing the current string prefix
        if the char is an opening bracket
            push the prefix string and number string to the stacks
            reset the prefix and number strings
        if the char is a closing bracket
            pop from the prefix and number (k) stacks
            make a new string of the current string "k" times (call this decoded)
            the the prefix to decoded string
            set current word equal to decoded
    result = decoded
    return the result
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public String decodeString(String s) {
        if(s == null) {
            return null;
        }
        
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> letterStack = new Stack<>();
        String result = "", k = "", letters = "";
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k += c;
            }
            else if(Character.isLetter(c)) {
                letters += c;
            }
            else if(c == '[') {
                letterStack.push(letters);
                numberStack.push(Integer.parseInt(k));
                
                letters = "";
                k = "";
            }
            // if char is a closing bracket ']'
            else {
                String prefix = letterStack.pop();
                int numRepeat = numberStack.pop();
                String decodedString = "";
                
                for(int i = 0; i < numRepeat; ++i) {
                    decodedString += letters;
                }
                letters = prefix + decodedString;
            }
        }
        
        result = letters;
        return result;
    }
}
