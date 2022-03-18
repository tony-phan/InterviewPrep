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
    Going over all cells, we can count only those that are the "first" cell of the battleship. First cell will be defined as the most top-left cell. We can check for first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them.
    
    Evaluate
    Time: O(N * M)
    Space: O(1)
    */
    public int countBattleships(char[][] board) {
        int result = 0;
        
        int rows = board.length, columns = board[0].length;
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(board[i][j] == '.') {
                    continue;
                }
                else if(i > 0 && board[i - 1][j] == 'X') { // check the top cell if the ship is a vertical ship
                    continue;
                }
                else if(j > 0 && board[i][j - 1] == 'X') { // check the left cell if the ship is a horizontal ship
                    continue;
                }
                ++result;
            }
        }
        return result;
    }
}
