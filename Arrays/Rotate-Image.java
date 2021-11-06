class Solution {
    /*
    Understand
    We are given a 2D matrix as input
    Rotate the matrix 90 degrees clockwise (in place)
    Return the modified matrix
    
    Example:
    1 2 3    7 4 1
    4 5 6 -> 8 5 2
    7 8 9    9 6 3
    
    Match
    Array problem
    
    Plan
    The way to do this is to rotate the matrix layer by layer
    calculate the number of layers (matrix length / 2)
    for layer 0 to total # of layers
        start = current layer
        end = (n - 1) - layer      (we do n - 1 b/c the arrays are 0indexed)
        for i = start to i < end
            REFERENCE: topLeft = matrix[start][i]
                       topRight = matrix[i][end]
                       bottomLeft = matrix[(n - 1) - i][start]
                       bottomRight = matrix[end][(n - 1 - i)]
            
            temp variable = topLeft
            topLeft = bottomLeft
            bottomLeft = bottomRight
            bottomRight = topRight
            topRight = temp variable
            
    Evaluate
    Time: O(N^2)
    Space: O(1)
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int layers = n / 2;
        for(int layer = 0; layer < layers; ++layer) {
            int start = layer;
            int end = (n - 1) - layer;
            for(int i = start; i < end; ++i) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[(n - 1) - i][start];
                matrix[(n - 1) - i][start] = matrix[end][(n - 1) - i];
                matrix[end][(n - 1) - i] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }
    }
}
