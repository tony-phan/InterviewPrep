public class Solution
{
    public int MinDistance(string word1, string word2)
    {
        int rows = word1.Length + 1, cols = word2.Length + 1;
        int[][] dp = CreateDpMatrix(rows, cols);

        for (int i = 0; i < rows; ++i)
        {
            dp[i][0] = i;
        }

        for (int i = 0; i < cols; ++i)
        {
            dp[0][i] = i;
        }

        for (int r = 1; r < rows; ++r)
        {
            char word1Char = word1[r - 1];
            for (int c = 1; c < cols; ++c)
            {
                char word2Char = word2[c - 1];
                if (word1Char == word2Char)
                {
                    dp[r][c] = dp[r - 1][c - 1];
                }
                else
                {
                    dp[r][c] = 1 + Math.Min(dp[r - 1][c - 1], Math.Min(dp[r - 1][c], dp[r][c - 1]));
                }
            }
        }

        // Print(dp);
        return dp[rows - 1][cols - 1];
    }

    private int[][] CreateDpMatrix(int rows, int cols)
    {
        int[][] dp = new int[rows][];
        for (int i = 0; i < rows; ++i)
        {
            dp[i] = new int[cols];
        }
        return dp;
    }

    private void Print(int[][] dp)
    {
        Console.WriteLine("dp");
        foreach (int[] row in dp)
        {
            Console.WriteLine(string.Join(",", row));
        }
    }
}

/*
word1 = "horse", word2 = "ros"

dp =   "" r ro ros
    ""  0 1  2   3
    h   1 1  2   3
   ho   2 2  1   2
  hor   3 2  2   2
 hors   4 3  3   2
horse   5 4  4   3

word1Char
word2Char

if word1Char == word2Char
    dp[i][j] = dp[i-1][j-1]
else
    dp[i][j] = 1 + Min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])

dp[i-1][j-1] -> replace
dp[i][j-1] -> insert
dp[i-1][j] -> delete
*/