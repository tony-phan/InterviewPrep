class Solution {
    /*
    Understand
    We are given a 2D matrix as input and a target value
    The matrix is in sorted ascending order
    We want to return if the matrix has the value target
    
    Match
    Array problem
    Search problem since the matrix is sorted (Binary search?)
    
    Plan
    Brute Force: check each value in the matrix (N^2 time)
    Optimized: For each row we're at, perform binary search
               Before doing binary search: check that target is between the first and last value of the row (first >= target <= last)
               Continue to the next row if target is not in the range
    
    Evaluate
    Time: O(N * log(N))
    Space: O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for(int[] row : matrix) {
            int first = row[0];
            int last = row[row.length - 1];
            
            if(target < first) {
                break;
            }
            else if(target > last) {
                continue;
            }
            else {
                result = binarySearch(row, 0, row.length - 1, target);
                break;
            }
        }
        return result;
    }
    private boolean binarySearch(int[] row, int left, int right, int target) {
        boolean found = false;
        while(left <= right) {
            int middle = (left + right)/2;
            if(row[middle] == target) {
                found = true;
                break;
            }
            else if(row[middle] < target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return found;
    }
}
