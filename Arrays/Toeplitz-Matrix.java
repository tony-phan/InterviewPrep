class Solution {
    /*
    Understand 
    We are given a 2D matrix as input
    Return true if the matrix is toeplitz
    Toeplitz: every diagonal from top-left to bottom-right has the same values
    
    Match
    2D Matrix problem
    
    Plan
    Loop through each cell in the matrix and check if the bottom right cell shares the same value (check bounds)
    Redundant work (we are checking every cell)
    
    Evaluate
    Time: O(N * M)
    Space: O(1)
    */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        for(int i = 0; i < rows - 1; ++i) {
            for(int j = 0; j < columns - 1; ++j) {
                if(inBoundary(matrix, i + 1, j + 1) && matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean inBoundary(int[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;
    }
}
