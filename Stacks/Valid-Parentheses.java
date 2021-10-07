class Solution {
    /*
    Understand
    input: "])(){"
    output: false
    
    input: "((][]))"
    output: false
    
    Match
    HashMap: can be used as fast lookup for comparison of closing and opening brackets
    Stack: can be used to store ordering of brackets we've seen so far as well as nested brackets
    
    Plan
    Loop through the string
    if the character is an opening bracket push it to the stack
    if the character is a closing bracket
        first check if the stack is empty (return false if it's empty)
        then check if the closing bracket and the top of the stack match correctly (return false if not correct)
    once finished checking the string, do one last check if the stack is not empty (return false if not empty)
    */
    public boolean isValid(String s) {
        if(s == null) {
            return false;
        }
        
        boolean result = true;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> stack = new Stack<>();
        for(Character bracket : s.toCharArray()) {
            if(bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            }
            else {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }
                
                if(bracket == map.get(stack.peek())) {
                   stack.pop(); 
                }
                else {
                    result = false;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty() && result) {
            result = false;
        }
        
        return result;
    }
}
