class Solution {
    /*
    Understand 
    We are given an input string s which contains letter and parenthese
    reverse all the letter between brackets
    it's possible to have nested brackets, so start from the inner most string
    
    example: Input: s = "(ed(et(oc))el)"
            Output: "leetcode"
            Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

    Match
    String problem
    Stack will need to be used to reverse nested strings
    
    Plan
    Create a stack
    loop through each letter in the string
        if the letter is a alphabet letter
            push into the stack if the stack is not empty
            else add the letter to the result string
        else if the letter is an opening parentheses
            push an open parentheses into the stack
        else
            we've hit a closing parentheses so we want to reverse the inner string
            get the inner reversed string by popping from the stack until we've hit '('
            pop '(' from the stack
            if the stack is empty, add the inner string to the result
            else push each letter of the inner string back into the stack
    return the result string
    
    Evaluate
    Time: O(n^2)
    Space: O(n)
    */
    public String reverseParentheses(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                if(stack.isEmpty()) {
                    result += c;
                }
                else {
                    stack.push(c);
                }
            }
            else if(c == '(') {
                stack.push('(');
            }
            else { // the current character is ')'
                String innerString = "";
                while(stack.peek() != '(') {
                    innerString += stack.pop();
                }
                stack.pop();
                
                if(stack.isEmpty()) {
                    result += innerString;
                }
                else {
                    for(char c1 : innerString.toCharArray()) {
                        stack.push(c1);   
                    }
                }
            }
        }
        return result;
    }
}
