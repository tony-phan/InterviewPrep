class Solution {
    /*
    Understand
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    For each cell we're at, look at it's top, left, and diagonal cells
    the max area at some cell = The minimum of those 3 values + 1
    
    Match
    Dynamic Programming
    dp[i][j] = the dimension of the largest square at that cell 
    
    Plan
    Create a 2d dp matrix
    copy all values from first row and leftmost column into the dp matrix
    start from second row second column cell
    if the val in the matrix is 0 continue
    else check that the diagonal, left, and top cell values are all not equal to 0
        if true, then get the min of those 3 values and set dp[i][j] = 1 + minimum
        else, dp[i][j] = 0
    result = max(result, dp[i][j])
    return result * result
    
    Evaluate
    Time: O(m*n)
    Space: O(m*n)
    */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        int[][] dp = new int[rows][columns];
        
        for(int i = 0; i < columns; ++i) {
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
            if(dp[0][i] == 1) {
                result = 1;
            }
        }
        for(int i = 0; i < rows; ++i) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            if(dp[i][0] == 1) {
                result = 1;
            }
        }
        
        for(int i = 1; i < rows; ++i) {
            for(int j = 1; j < columns; ++j) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                
                if(dp[i - 1][j - 1] != 0 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0) {
                    int diagonal = dp[i - 1][j - 1];
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    
                    int minimum = Math.min(Math.min(diagonal, left), top);
                    dp[i][j] = 1 + minimum;
                }
                else {
                    dp[i][j] = 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}
