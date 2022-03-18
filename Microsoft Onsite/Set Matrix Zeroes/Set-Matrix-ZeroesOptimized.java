class Solution {
    /*
    0 0 0
    1 0 1
    1 0 1
    
    Optimized approach: use the first row and column of the matrix to indicate if a row/column should be zeroed out
    
    1. traverse the first row and column to check if they contain a 0 (store in boolean flag)
    2. traverse the matrix starting from position (1,1), if the current cell is a 0, set the first row and column value to 0
    3. traverse the matrix again starting from position (1,1), if the starting row or column value is 0, set the column to 0
    4. if the firstRow or firstColumn contain a 0, make the entire row/column 0
    
    
    Time: O(m*n)
    Space: O(1)
    */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        
        // step 1
        for(int i = 0; i < n; ++i) {
            if(matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        for(int i = 0; i < m; ++i) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        
        // step 2
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //step 3
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                   matrix[i][j] = 0; 
                }
            }
        }
        
        // step 4
        if(firstRow) {
            for(int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }
        if(firstCol) {
            for(int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}

