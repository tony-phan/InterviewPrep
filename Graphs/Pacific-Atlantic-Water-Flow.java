class Solution {
    /*
    Understand
    2D matrix that represents an island
    each value in matrix = height above sea level
    at each cell, check if water can flow from that cell to both pacific & atlantic ocean
    water can only flow to neighbor cells if the neighbor cell's height is less than or equal to current cell height
    
    output: list of cells that can flow water to both oceans (coordinates)
    
    1 2 2 3    output: [[0,3],[1,0],[0,1],[0,2],[1,1],[1,2],[1,3]]  
    3 2 3 4
    
    Match
    Graph problem
    Graph Traversal: DFS or BFS?
    
    Plan
    We want to form 2 matrices
        One matrix that shows all cells that can reach the pacific ocean
        One matrix that shows all cells that can reach the atlantic ocean
        The intersection of these two matrices is our answer
    
    All cells that can reach the pacific ocean is any cell in row 0 & column 0
    All cells that can reach the atlantic ocean is any cell in the last row & last column 
    Begin our DFS search for all cells in the first & last rows & columns
    In the DFS
        if out of boundaries stop traversing
        if our previous height > current cell OR if we've seen this cell and it's true stop traversing
        set this cell to be true and recursively call the dfs on the top,right,left, and bottom cells
        
    Evaluate
    Time: O(N*M)
    Space: O(N*M)
    */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length, columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];
        
        //DFS
        for(int i = 0; i < columns; ++i) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, rows - 1, i, Integer.MIN_VALUE, atlantic);
        }
        for(int i = 0; i < rows; ++i) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, columns - 1, Integer.MIN_VALUE, atlantic);
        }
        
        for(int row = 0; row < rows; ++row) {
            for(int column = 0; column < columns; ++column) {
                if(pacific[row][column] && atlantic[row][column]) {
                    result.add(Arrays.asList(row, column));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] island, int row, int column, int previousHeight, boolean[][] ocean) {
        if(row < 0 || row >= island.length || column < 0 || column >= island[row].length) {
            return;
        }
        
        if(island[row][column] < previousHeight || ocean[row][column]) {
            return;
        }

        ocean[row][column] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        for(int[] direction : directions) {
            dfs(island, row + direction[0], column + direction[1], island[row][column], ocean);
        }
    }
}
