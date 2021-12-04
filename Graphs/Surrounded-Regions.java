class Solution {
    /*
    Understand
    We are given a matrix containing either 'X' or 'O'
    We want to "capture" all regions that are surrounded by 'X' (surrounded means there is an 'X' at the top, bottom, left, and right of the region)
    "Capture" a region: flip all adjacent 'O's into 'X'
    If the matrix is of size 2x2 or smaller, then all cells are connected to a border so do nothing
    We only want to check through cells that are not touching a border
    Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
    
    Match
    Graph - maxtrix representation
    DFS/BFS traversal to get region of 'O'
    
    Plan
    Check all the border cells of the matrix
    If any of the border cells are 'O' then do a dfs to find other 'O's connected to it and mark it a special character '#'
    Traverse through the matrix again
        if any cells have the value '#' then set it to O
        if any cells have the value 'O', then set it to X
    
    Evaluate
    Time: O(N * M)
    Space: O(N * M)
    */
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        if(board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        
        int rows = board.length, columns = board[0].length;
        for(int i = 0; i < columns; ++i) {
            if(board[0][i] == 'O') { // first row
                dfs(board, 0, i);
            }
            if(board[rows - 1][i] == 'O') { // last row
                dfs(board, rows - 1, i);
            }
        }
        for(int i = 0; i < rows; ++i) {
            if(board[i][0] == 'O') { // first column
                dfs(board, i, 0);
            }
            if(board[i][columns - 1] == 'O') { // last column
                dfs(board, i, columns - 1);
            }
        }
        
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(board[i][j] == 'X') {
                    continue;
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int row, int column) {
        if(!inBoundary(board, row, column) || board[row][column] == 'X' || board[row][column] == '*') {
            return;
        }
        board[row][column] = '*';
        for(int[] direction : directions) {
            dfs(board, row + direction[0], column + direction[1]);
        }
    }
    private boolean inBoundary(char[][] board, int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }
}
