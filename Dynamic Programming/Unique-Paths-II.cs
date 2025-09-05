public class Solution
{
    public int UniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int rows = obstacleGrid.Length, cols = obstacleGrid[0].Length;
        int[][] dp = Create2dArray(rows, cols);

        // base case
        if (obstacleGrid[0][0] == 0)
        {
            dp[0][0] = 1;
        }
        else
        {
            dp[0][0] = 0;
        }

        for (int r = 0; r < rows; ++r)
        {
            for (int c = 0; c < cols; ++c)
            {
                if (r == 0 && c == 0) continue;
                if (obstacleGrid[r][c] == 1)
                {
                    dp[r][c] = 0;
                    continue;
                }

                // check top cell
                if (InBounds(r - 1, c, rows, cols))
                {
                    dp[r][c] += dp[r - 1][c];
                }
                // check left cell
                if (InBounds(r, c - 1, rows, cols))
                {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    private bool InBounds(int row, int col, int numRows, int numCols)
    {
        return 0 <= row && row < numRows && 0 <= col && col < numCols;
    }

    private int[][] Create2dArray(int rows, int cols)
    {
        int[][] dp = new int[rows][];
        for (int i = 0; i < rows; ++i)
        {
            dp[i] = new int[cols];
        }
        return dp;
    }
}

/*
obstacleGrid
    0 0 0
    0 1 0
    0 0 0
dp  1  1 1 
    1  0 1
    1  1 2

check if dp[i-1,j] & dp[i,j-1] are within bounds and not an obstacle

if top cell is in bounds AND a square
if left cell is in bounds AND a square
    dp[i,j] += obstacleGrid[i,j]

obstacleGrid -> 4 ways
    0 0 1
    0 0 0
    1 0 0
dp 
    1 1 -1
    1 2  2
   -1 2  4
*/