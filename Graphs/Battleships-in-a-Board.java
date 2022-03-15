class Solution {
    /*
    Understand
    We are given a M*N matrix where each cell is a battleship 'X' or empty '.', return the # of battle ships on board
    Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
    
        Example:
        X . . X
        . . . X     output = 2
        . . . X
        . . . .
    
    Match
    Matrix problem
    DFS
    
    Plan
    traverse the matrix
    if the current cell is 'X', then we've hit a battleship
    increment the counter storing the # of battleships
    do a dfs starting at that cell to mark off the battleship so we don't count it again
    
    Evaluate
    Time: O(N * M)
    Space: O(1)
    */
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // top, bottom, left, right
    public int countBattleships(char[][] board) {
        int result = 0;
        
        int rows = board.length, columns = board[0].length;
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(board[i][j] == 'X') {
                    ++result;
                    dfs(board, i, j);
                }
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int row, int column) {
        if(!inBoundary(board, row, column) || board[row][column] != 'X') {
            return;
        }
        board[row][column] = '.';
        for(int[] direction : directions) {
            dfs(board, row + direction[0], column + direction[1]);
        }
    }
    
    private boolean inBoundary(char[][] board, int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[row].length;
    }
}
