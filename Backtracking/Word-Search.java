class Solution {
    /*
    Understand
    We are given an MxN grid of character and a string word. Return true if the word exists in the grid
    the word can be constructed by adjacent (top,bottom,left,right) cells
    the same letter cell cannot be used more than once
    
    Example: A B C E
             S F C S
             A D E E
             word = "ABCCED"
             result: true
    
    Match
    Backtracking
    DFS traversal
    
    Plan
    The idea is to find a match first character and do a DFS on that cell to check if the words exists
    traverse the grid
    if grid[i][j] == first character of word
        do a dfs at grid[i][j]
        return true if dfs is true
    return false
    
    DFS traversal
    if the row&column is out of bounds OR if we've visited this cell OR if the first letter of word != grid[i][j]
        return false
    if word.length == 1
        return true
    
    mark grid[i][j] as visited
    for each adjacent cell
        word = word.substring(1)
        perform DFS on the adjacent cell
        if the DFS returns true
            return true
    mark the current cell as unvisited
    return false
    
    Evaluate:
    Time: O(n x m)
    Space: O(n x m)
    */
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // top, bottom, left, right
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        
        int rows = board.length, columns = board[0].length;
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(board[i][j] != word.charAt(0)) {
                    continue;
                }
                boolean search = backtrack(board, word, i, j, new boolean[rows][columns]);
                if(search) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int row, int column, boolean[][] visited) {
        if(!inBoundary(board, row, column) || visited[row][column] || word.charAt(0) != board[row][column]) {
            return false;
        }
        else if(word.length() == 1) {
            return true;
        }
        
        boolean result = false;
        visited[row][column] = true;
        String original = word;
        for(int[] direction : directions) {
            word = word.substring(1);
            boolean search = backtrack(board, word, row + direction[0], column + direction[1], visited);
            if(search) {
                result = true;
                break;
            }
            word = original;
        }
        visited[row][column] = false;
        return result;
    }
    private boolean inBoundary(char[][] board, int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[row].length;
    }
}
/*
A B C E
S F E S
A D E E

ABCESEEEFS
*/
