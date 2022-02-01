class Solution {
    /*
    Understand
    We are given an int n and we want to generate an n x n matrix filled with elements from 1 to n^2 in     spiral order 
    
    Example: n = 3
             result: 1 2 3
                     8 9 4
                     7 6 5
    Match
    Matrix problem
    
    Plan
    Use variables to store the top, bottom, left, and right boundaries to help us spiral traverse
    use a direction variable to help us determine which direction to traverse
    if we're going from left to right
        the row is constant, the column changes
        update the value and direction
    if we're going from top to bottom
        the row changes, the column is constant
        update the value and direction
    if we're going from right to left
        the row is constant, the column changes
        update the value and direction
    if we're going from bottom to top
        the row changes, the column is constant
        update the value and direction
    return the result
    
    Evaluate
    Time: O(N^2)
    Space: O(N^2)
    */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int topBoundary = 0, bottomBoundary = n - 1, leftBoundary = 0, rightBoundary = n - 1; 
        
        int value = 1;
        int direction = 0; // 0 (left to right), 1 (top to bottom), 2 (right to left), 3 (bottom to top)
        
        while(topBoundary <= bottomBoundary && leftBoundary <= rightBoundary) {
            if(direction == 0) {
                for(int i = leftBoundary; i <= rightBoundary; ++i) {
                    result[topBoundary][i] = value++;
                }
                direction = 1;
                ++topBoundary;
            }
            else if(direction == 1) {
                for(int i = topBoundary; i <= bottomBoundary; ++i) {
                    result[i][rightBoundary] = value++;
                }
                direction = 2;
                --rightBoundary;
            }
            else if(direction == 2) {
                for(int i = rightBoundary; i >= leftBoundary; --i) {
                    result[bottomBoundary][i] = value++;
                }
                direction = 3;
                --bottomBoundary;
            }
            else {
                for(int i = bottomBoundary; i >= topBoundary; --i) {
                    result[i][leftBoundary] = value++;
                }
                direction = 0;
                ++leftBoundary;
            }
        }
        return result;
    }
}
