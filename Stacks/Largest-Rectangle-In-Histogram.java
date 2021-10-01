class Solution {
    /*
    Understand
    
    Match
    Stack: use a stack to keep track of the building's height and the building's start position index
           the height stack will stores 
           
    Example: heights = [2,1,5,6,2,3]
       (top)           (top)
        | |             | |
        | |             | |        
        |2|             |2|  the bar with height 2 has a start position of 2 even though it's index in the height array is 4 
        |1|             |0|  the bar with height 1 has a start position of 0 even though it's index in the height array is 0
      (bottom)        (bottom)
   height-stack     position-stack
    Plan
    Loop through the bar heights
    the first bar will automatically be added to the height & position stacks
    if the current bar is taller than top of height stack
        push that height and current index to height and position stacks
        continue
    if the current bar is shorter than the top of height stack (have this in a while loop)
        pop from the height stack and calcuate its area
        check if the height of new top of height stack is still taller
            if yes then we want to pop from position stack to get rid of the start position of the height we popped earlier from the height stack
    
    finally push the current height into the height stack
    
    once we've loop through all the heights, calculate the remaining areas of the heights in the height stack
        
    
    Evaluate
    Time: O(n)
          We only have to loop through the array once
    Space: O(n)
    */
    public int largestRectangleArea(int[] heights) {
        int result = Integer.MIN_VALUE;
        
        // size of height&position stacks should always be the same as we traverse the height array
        // 
        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> positionStack = new Stack<>();
        
        for(int i = 0; i < heights.length; ++i) {
            // if we're looking at the first building or if we hit a taller building
            if(i == 0 || heights[i] > heightStack.peek()) {
                heightStack.push(heights[i]);
                positionStack.push(i);
                continue;
            }
            
            // if we hit a shorter building
            if(heights[i] < heightStack.peek()) {
                // while we have taller buildings in the stack, we want to pop from the stack and also figure out what index position the current bar starts at in the position stack
                while(!heightStack.isEmpty() && heights[i] < heightStack.peek()) {
                    int area = getArea(heightStack.pop(), positionStack.peek(), i);
                    result = Math.max(result, area);
                    
                    // if current bar's height is less than the bar height at top of stack, then we want to discard the position of the bar we popped earlier b/c we now know current's position won't start there by popping from the positionStack
                    if(!heightStack.isEmpty() && heights[i] < heightStack.peek()) {
                        positionStack.pop();
                    }
                }
                // at this point we now know what index the current bar starts at, we now just have to push it's height to the height stack
                heightStack.push(heights[i]);
            }
        }
        
        // while we have leftover bars, calculate their remaining areas
        while(!heightStack.isEmpty()) {
            int tempHeight = heightStack.pop();
            int tempPosition = positionStack.pop();
            int area = getArea(tempHeight, tempPosition, heights.length);

            result = Math.max(result, area);
        }
        
        return result;
    }
    
    private int getArea(int height, int startPosition, int endPosition) {
        return height * (endPosition - startPosition);
    }
}
