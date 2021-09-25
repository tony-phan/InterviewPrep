class Solution {
    /*
    Understand:
    path = "/home/a/b/.././e"
    output: "/home/a/e"
    
    Match: stack
    
    Plan
    Create a stack
    Split the path using the string split method ("/" as delimiter)
    for each directory
        if the directory is not equal to "." and ".." and ""
            push to stack
        if the directory equals ".." and the stack is not empty
            pop from the stack
            
    construct the result
    each time you pop from the stack append that to the left side of the result string
    */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        
        for(String directory : directories) {
            if(!directory.equals("..") && !directory.equals(".") && !directory.equals("")) {
                stack.push(directory);
            }
            else {
                if(!stack.isEmpty() && directory.equals("..")) {
                    stack.pop();
                }
            }
        }
        
        String result = "";
        if(stack.isEmpty()) {
            result = "/";
        }
        else {
            while(!stack.isEmpty()) {
                result = "/" + stack.pop() + result;
            }
        }
        return result;
    }
}
