class Solution {
    /*
    Basically, we traverse through each diagonal value in the matrix and apply binary search to the current row and binary search to the current column we are at
    
    Evaluate
    Time: O(log(n) * min(m, n))
    Space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        
        int row = 0, column = 0;
        while(row < matrix.length && column < matrix[0].length) {
            if(matrix[row][column] <= target && target <= matrix[row][matrix[0].length - 1]) {
                result = binarySearchRow(matrix, row, target, row, matrix[0].length - 1);
                if(result) {
                    break;
                }   
            }
            if(matrix[row][column] <= target && target <= matrix[matrix.length - 1][column]) {
                result = binarySearchColumn(matrix, column, target, column, matrix.length - 1);
                if(result) {
                    break;
                }
            }
            ++row;
            ++column;
        }
        return result;
    }
    
    private boolean binarySearchRow(int[][] matrix, int row, int target, int left, int right) {
        boolean result = false;
        
        while(left <= right) {
            int midpoint = left + (right - left)/2;
            if(matrix[row][midpoint] == target) {
                result = true;
                break;
            } else if(matrix[row][midpoint] < target) {
                left = midpoint + 1;
            }
            else {
                right = midpoint - 1;
            }
        }
        return result;
    }
    
    private boolean binarySearchColumn(int[][] matrix, int column, int target, int top, int bottom) {
        boolean result = false;
        
        while(top <= bottom) {
            int midpoint = top + (bottom - top)/2;
            if(matrix[midpoint][column] == target) {
                result = true;
                break;
            } else if(matrix[midpoint][column] < target) {
                top = midpoint + 1;
            }
            else {
                bottom = midpoint - 1;
            }
        }
        return result;
    }
}
