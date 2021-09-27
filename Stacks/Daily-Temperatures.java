class Solution {
    /*
    Main problem: how to figure out the # of days to wait until there is a warmer temperature
                  basically get the next greatest element for the current position we're at
    
    Understand
    temperatures = [30,33,45,31,77,44,64,43,65,73,87,54,90,45,65,34,87,67,89,54,90]
          output = [1,  1, 2, 1, 0, 1, 0]
          
    temperatures = [73,74,75,71,69,72,76,73]
                                         i
    Output: [1,1,4,2,1,1,0,0]
    
    stack (bottom)  (top)
    output[1,1,4,2,1,1,0,0]
    
    Match
    stack: can be used to keep the order of temperatures we've looked through
           the stack will keep indexes of temperatures that need to find a warmer temp
           anytime we hit a warmer temp, we want to update in the result array (while loop)
            calculate the number of days
            store that at the index of the top of stack in result array
            pop from the stack
           at the end of the while loop, push the index of current temp to the stack
           
           specifically use a monotonic stack
    
    Plan
    Loop through each temperature
    if the current temperature is less than the top of the stack
        push that element to the stack
        continue
    while the current temperature is greater than the top of the stack and the stack is not empty
        calculate the index difference and store in result 
        pop from stack
    push the index of current temp into the stack (after the while loop)
    
    Evaluate
    Time: O(n)
    Space: O(n)
    */
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null) {
            return null;
        }
        
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
            
        for(int i = 1; i < temperatures.length; ++i) {
            if(temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
                continue;
            }
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int numDays = i - stack.peek();
                result[stack.peek()] = numDays;
                
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int leftoverIndex = stack.pop();
            result[leftoverIndex] = 0;
        }
        
        return result;
    }
}
