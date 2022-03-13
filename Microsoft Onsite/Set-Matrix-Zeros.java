class Solution {
    /*
    Understand 
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    Example: 1 1 1    1 0 1
             1 0 1 -> 0 0 0
             1 1 1    1 0 1
             
    Match
    Matrix problem
    
    Plan
    Traverse the matrix
    if the current cell value is 0, store the index of its row and column in a set
    traverse the matrix again and set any cells to 0 if its row and column is in a 0 row or column
    
    Evaluate
    Time: O(m * n)
    Space: O(m + n)
    */
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>(), zeroColumns = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroColumns.add(j);
                }
            }
        }
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(zeroRows.contains(i) || zeroColumns.contains(j)) {
                   matrix[i][j] = 0; 
                }
            }
        }
    }
}
