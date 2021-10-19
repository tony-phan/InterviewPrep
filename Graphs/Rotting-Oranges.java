class Solution {
    /*
    Understand
    Can I assume that the grid will only contain 1 rotten orange? No, there can be multiple rotten oranges initially
    We want to return the minimum number of minutes until all oranges are rotten
    Return -1 if this cannot happen
    
    Match
    Graph - matrix representation
    BFS traversal - want to find a minimum
    
    Plan
    Traverse the grid and store all the locations of the rotten oranges in a queue
    Do a BFS through the grid
        for all rotten oranges, make all it's adjacent neighbors rotten
        add those adjacent new rotten oranges into the queue
        keep track of which cells we've already visited with a boolean grid
        each BFS level is a minute
    
    Evaluate
    Time: O(N * M)
    Space: O(N * M)
    */
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int rows = grid.length, columns = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int numFresh = 0;
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    ++numFresh;
                }
            }
        }
        
        if(numFresh == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // top, bottom, left, right
        
        int minutes = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; ++i) {
                int[] rottenOrange = queue.poll();
                int row = rottenOrange[0], column = rottenOrange[1];
                for(int[] direction : directions) {
                    int[] neighbor = new int[]{row + direction[0], column + direction[1]};
                    if(!inBoundary(grid, neighbor[0], neighbor[1]) || grid[neighbor[0]][neighbor[1]] == 2 || grid[neighbor[0]][neighbor[1]] == 0 || visited[neighbor[0]][neighbor[1]]) {
                        continue;
                    }
                    grid[neighbor[0]][neighbor[1]] = 2;
                    queue.add(new int[]{neighbor[0], neighbor[1]});
                    --numFresh;
                }
                visited[row][column] = true;
            }
            ++minutes;
        }
        //we do minutes - 1 because minutes starts at 0
        return numFresh == 0 ? minutes - 1 : -1;
    }
    private boolean inBoundary(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length;
    }
}
