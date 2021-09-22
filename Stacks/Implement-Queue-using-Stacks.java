/*
    Understand
    ["MyQueue", "empty", "push", "push", "peek", "pop", "empty", "peek"]
    [[], [], [4], [2], [], [], [], []]
    
    output: [[null],[true],[null],[null],[4],[4],[false],[2]]
    
    (front)4,2(end)
    
    [push(1),push(9),peek = 1, pop,pop,push(6), empty=false,peek=6]
    (front)6 (end)
    
    Match
    Stacks: use one stack to hold values as they come in the queue (stack holder)
            use the other stack as a reverse stack, so top of this stack will be front of queue
    
    Plan
    push: add x into stack holder
    pop: move elements from stack holder into reverseStack, clear stack holder, pop from the reverse stack, and move elements back into the stack holder (may need to clear the reverseStack)
    peek: move elements from stack holder into reverseStack, clear stack holder, peek from reverse stack, move elements back to stack holder (may need to clear reverse stack)
    empty: return if stack holder is empty
    
    Evaluate
    
    push: Time - O(1)
          Space - O(1)
          
    pop: Time - O(n)
         Space - O(n)
         
    peek: Time - O(n)
          Space - O(n)
    empty: Time - O(n)
           Space - O(n)
*/

class MyQueue {
    
    Stack<Integer> valuesHolder;
    Stack<Integer> reverseStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        valuesHolder = new Stack<>();
        reverseStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        valuesHolder.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transferValues(valuesHolder, reverseStack);
        int poppedValue = reverseStack.pop();
        transferValues(reverseStack, valuesHolder);
        
        return poppedValue;
    }
    
    /** Get the front element. */
    public int peek() {        
        transferValues(valuesHolder, reverseStack);
        int frontElement = reverseStack.peek();
        transferValues(reverseStack, valuesHolder);
        
        return frontElement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return valuesHolder.empty();
    }
    
    private void transferValues(Stack<Integer> source, Stack<Integer> destination) {
        while(!source.empty()) {
            destination.push(source.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
