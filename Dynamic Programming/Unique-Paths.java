class Solution {
    /*
    Understand
    For each cell in the grid, the number of unique paths to it is the sum of the values of the left and top neighbors
    since the robot can only move down and right, we check the top and left cells 
    By default, all cells in the top row and leftmost column will keep the same value 
    
    Match
    Dynamic Programming
    
    Plan
    Create a new 2d array of size m*n to store dp values
    set values of dp matrix's top row and leftmost column same as the input's values
    starting from the second row and second column, go through each cell
    each cell's value is equal to sum of top cell value and left cell value
    return bottom right cell's value
    
    Evaluate
    Time: O(m*n)
    Space: O(m*n)
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
