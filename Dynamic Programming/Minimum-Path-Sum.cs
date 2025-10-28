public class Solution
{
    public int MinPathSum(int[][] grid)
    {
        int rows = grid.Length;
        int cols = grid[0].Length;

        int[][] dp = Create2dArray(rows, cols);
        dp[0][0] = grid[0][0];
        // first row
        for (int i = 1; i < cols; ++i)
        {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // first col
        for (int j = 1; j < rows; ++j)
        {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < rows; ++i)
        {
            for (int j = 1; j < cols; ++j)
            {
                dp[i][j] = grid[i][j] + Math.Min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // Console.WriteLine("dp");
        // foreach(int[] r in dp) {
        //     Console.WriteLine(string.Join(", ", r));
        // }
        return dp[rows - 1][cols - 1];
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
1 3 1
1 5 1
4 2 1

dp
1 4 5
2 7 6
6 8 7



1 2 3
4 5 6

dp
1 3 6
5 8 12


*/