class Solution {
    /*
    Essentially we want to get rid of all the balanced pairs of parentheses
    After doing this we'll end up with the unbalanced parentheses is this form (example): )))(((
    The minimum number of swaps to make the unbalanced parentheses balanced is: ceil(numOpenBrackets / 2)
    return that value
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int numOpen = 0, numClosed = 0;
        for(char bracket : s.toCharArray()) {
            if(bracket == '[') {
                stack.push(bracket);
                ++numOpen;
            }
            else { // bracket == ')'
                if(stack.isEmpty()) {
                    stack.push(bracket);
                    ++numClosed;
                }
                else {
                    char topBracket = stack.peek();
                    if(topBracket == '[') {
                        stack.pop();
                        --numOpen;
                    }
                    else {
                        stack.push(bracket);
                        ++numClosed;
                    }
                }
            }
        }        
        return numOpen == numClosed ? (int)Math.ceil((double)numOpen / 2) : -1;
    }
}
