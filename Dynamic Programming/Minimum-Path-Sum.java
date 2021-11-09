class Solution {
    /*
    Understand
    We are given a 2D grid containing int's as input
    We want to return the minimum sum of the path from top leftt to bottom right
    we can only move in the right or down directions
    
    Example: 1 3 1
             1 5 1    output = 7 b/c the minimum sum path is follows: 1 -> 3 -> 1 -> 1 -> 1 = 7
             4 2 1
    How can we find the minimum path sum? Brute force would be to dfs traverse the grid and calculate a min sum (this probably wouldn't work actually)
    Dynamic programming? How about for each cell we're at, have it store the min sum to get to that cell starting at the top left (overwrite it's value to that min value)
        for each cell grab it's top and left neighbor cell's value, add the cell's value to the minimum of left and top value, then overwrite the current cells value
        do this for every cell in the grid
        
        Example: 1 3 1      1 4 5
                 1 5 1  ->  2 7 6   after applying dp, grid[i][j] now equals the min sum to get to that 
                 4 2 1      6 8 7   cell starting from top left, really clever!
              (before dp) (after dp)
    Match
    Dynamic Programming, for each value in the grid we want to store the min sum to get to that cell
    
    Plan
    If the grid is 1x1 then return the only element
    Loop through each cell in the grid
    At each value we're at, get the value of the cell's top and left neighbors (if the neighbors are out of bounds set their values to Integer.MAX_VALUE)
    overwrite the current cell's value to equal the sum of the current cell value and the minimum of the left&top values
    return the value of the bottomest&rightmost cell
    
    Evaluate
    Time: O(N * M)
    Space: O(1)
    */
    
    public int minPathSum(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        
        int rows = grid.length, columns = grid[0].length;
        int[] left = {0, -1}, top = {-1, 0};
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(i == 0 && j == 0) {
                    continue;
                }
                int leftVal = boundaryCheck(grid, i + left[0], j + left[1]) ? grid[i + left[0]][j + left[1]] : Integer.MAX_VALUE;
                int topVal = boundaryCheck(grid, i + top[0], j + top[1]) ? grid[i + top[0]][j + top[1]] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(leftVal, topVal);
            }
        }
        int result = grid[rows - 1][columns - 1];
        return result;
    }
    // return true if in bounds, false if out of bounds
    private boolean boundaryCheck(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length;
    }
}
