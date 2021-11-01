class Solution {
    /*
    Understand
    We are given a 2D matrix as input and we want to output the all elements of the matrix in spiral order
    Example: 1 2 3
             4 5 6 = [1 2 3 6 9 8 7 4 5]
             7 8 9
    Main Problem: How to traverse a matrix in spiral order (clockwise direction)? (I dunno)
    
    Match
    Array/Matrix problem
    
    Plan
    Utilize boundary variables to help us move in a spiral direction
    We will also use a direction to store the current direction for us to move 
        - 0(left to right), 1(top to bottom), 2(right to left), 3(bottom to top)
    While the left boundary is less than or equal to right boundary AND top boundary is less than or equal to bottom boundary
        if direction is 0
            add elements in matrix from left to right into the result list
            update direction to 1
            update the topBoundary (topBoundary++)
        if direction is 1
            add elements in matrix from top to bottom into the result list
            update direction to 2
            update the rightBoundary (rightBoundary--)
        if direction is 2
            add elements in matrix from right to left into the result list
            update direction to 3
            update the bottomBoundary (bottomBoundary--)
        if direction is 3
            add elements in matrix from bottom to top into the result list
            update direction to 0
            update the leftBoundary (leftBoundary++)
    return list result
    
    Evaluate
    Time: O(N * M)
    Space: O(N * M)
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int leftBoundary = 0, rightBoundary = matrix[0].length - 1, topBoundary = 0, bottomBoundary = matrix.length - 1;
        
        int direction = 0; // 0(left to right), 1(top to bottom), 2(right to left), 3(bottom to top)
        while(leftBoundary <= rightBoundary && topBoundary <= bottomBoundary) {
            if(direction == 0) { 
                for(int i = leftBoundary; i <= rightBoundary; ++i) {
                    result.add(matrix[topBoundary][i]);
                }
                ++topBoundary;
                direction = 1;
            }
            else if(direction == 1) {
                for(int i = topBoundary; i <= bottomBoundary; ++i) {
                    result.add(matrix[i][rightBoundary]);
                }
                --rightBoundary;
                direction = 2;
            }
            else if(direction == 2) {
                for(int i = rightBoundary; i >= leftBoundary; --i) {
                    result.add(matrix[bottomBoundary][i]);
                }
                --bottomBoundary;
                direction = 3;
            }
            else {
                for(int i = bottomBoundary; i >= topBoundary; --i) {
                    result.add(matrix[i][leftBoundary]);
                }
                ++leftBoundary;
                direction = 0;
            }
        }
        return result;
    }
}
