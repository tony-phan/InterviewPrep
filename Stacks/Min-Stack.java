class MinStack {

    /** initialize your data structure here. */
    
    /*
    Understand
    ["Minstack", "push", "push", "top", "pop","push", "getMin", "pop"]
    [[]            [3]      [-6]   []     []     [-3]    []       []]
    
    bottom   3                       top
    output: [null,null,null,-6,null,null,-3]
    
    stack: (bottom) 4,-5,-2,5          (top)
    min stack: (bottom)5,4,-2,-5            (top)
    minimum = -5
    pop()
    Match
    Stack
    
    Plan
    Use two stack: one stack as the real stack as another as the minimum stack
    the minimum stack will hold the ordering of the current minimum for the current stack's size
        Example:  |    |                         |    |
                  | 13 |                         |  -7 |
                  | -7 |                         |  -7 |
                  | -4 |                         |  -4 |
                  | 3  |                         |  2  |
                  | 2  | (bottom)                |  2  | (bottom)
                   real                         minimumStack
                                                *each value in the minimum represent the current minimum of the relative to how many elements are in the stack based off its position in the stack
    for push
        real stack: just push into stack
        min stack: compare the val with the current min
            get the new minimum: math.max(val, current minimum)
            add new minimum to minimumstack
    for pop: pop from both min and real stack
             set current min to top of min stack
    for top: return top of real stack
    getMin: return the current min
    
    Evaluate
    Time: O(1)
    Space: O(n)
    */
    
    Stack<Integer> realStack;
    Stack<Integer> minimumStack;
    
    public MinStack() {
        realStack = new Stack<>();
        minimumStack = new Stack<>();
    }
    
    public void push(int val) {
        realStack.push(val);
        
        int minimum = minimumStack.empty() ? Integer.MAX_VALUE : minimumStack.peek();
        
        minimumStack.push(Math.min(val, minimum));
    }
    
    public void pop() { 
        realStack.pop();
        minimumStack.pop();
    }
    
    public int top() {
        return realStack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
