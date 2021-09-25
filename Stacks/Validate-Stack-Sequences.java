class Solution {
    /*
    Understand
    
    Happy Case:
    pushed = [1,2,3,7,5], popped = [2,7,3,5,1]
    true
    
    Edge Case: 
    pushed = [1,2,3,7], popped = [2,3,1,7]
    bottom[1,7]top
    false
    
    Match
    Stack: we can use an actual stack to do the simulation
    
    Plan
    loop through each element in pushed array
    push that element into the stack
    check that stack size is not empty and if the top of stack is equal to the current element at popped array (while loop)
        if yes, pop from the stack
                move popped pointer forward in array
    
    return if the stack is empty
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        
        for(int num : pushed) {
            stack.push(num);
            while(!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                stack.pop();
                ++poppedIndex;
            }
        }
        
        return stack.isEmpty();
    }
}
