class Solution {
    /*
    Understand
    We are given a MxN matrix (consisting only of 0's and 1's) as input, and for every value in the matrix that is 0, we want to set it's entire row and column to 0.
    Example: 1 1 1    1 0 1
             1 0 1 -> 0 0 0
             1 1 1    1 0 1
    Match
    Matrix problem
    
    Plan
    Traverse through the matrix and for each 0 that we encounter, we want to store its row and column inside a row and column set
    Traverse the matrix again and check the current row and column we're at:
        if the current row is in the row set or if the current column is in the column set, make the current cell 0
    
    Evaluate
    Time: O(n^2)
    Space: O(n)
    */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> columnsToZero = new HashSet<>();
        
        int rows = matrix.length, columns = matrix[0].length;
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(matrix[i][j] == 0) {
                    rowsToZero.add(i);
                    columnsToZero.add(j);
                }
            }
        }
        
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(rowsToZero.contains(i) || columnsToZero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

