class Solution {
    /*
    Understand
    tokens = ["10","11","9","3","/","0","+","-","*","17","+","3","*"]
    expression = 10 11 9 3 / 0 + - * 17 + 3 *
                 (((10 * (11 - ((9/3) + 0))) + 17) * 3)
                 = 291
    
    Match
    Stack: can be used to keep the ordering of the expression
    
    Plan
    loop through the tokens array
    if the token is an operand, push it to the stack
    if the token is an operator
        pop two elements from the stack (pay attention to which operand is the left operand and right operand)
        use a helper method to evaluate the operator and operands
        push the result to the stack
    by the end the stack should only contain one element
    pop from the stack and return it
    */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer rightOperand = stack.pop();
                Integer leftOperand = stack.pop();
                
                stack.push(evaluateExpression(token, leftOperand, rightOperand));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private Integer evaluateExpression(String operator, Integer operand1, Integer operand2) {        
        if(operator.equals("+")) {
            return operand1 + operand2;
        }
        else if(operator.equals("-")) {
            return operand1 - operand2;
        }
        else if(operator.equals("*")) {
            return operand1 * operand2;
        }
        else {
            return operand1 / operand2;
        }
    }
}
