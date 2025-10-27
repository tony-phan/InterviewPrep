public class Solution
{
    public long MostPoints(int[][] questions)
    {
        int n = questions.Length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; --i)
        {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            long skipQuestionPoints = dp[i + 1];
            long solveQuestionPoints = points + (i + brainpower + 1 < n ? dp[i + brainpower + 1] : 0);

            dp[i] = Math.Max(skipQuestionPoints, solveQuestionPoints);
        }
        // Console.WriteLine($"dp: {string.Join(",", dp)}");
        return dp[0];
    }
}

/*
questions = [[3,2],[4,3],[4,4],[2,5]]
               i
dp=[5,4,4,2]

Move from right to left

at index i
A = question i points + dp[(i + question brainpower)] question points
B = dp[i+1]

dp[i]=Max(A,B)


questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
               i

dp=[7,7,5,5,5]

assume we start at question at i: A=question[i] points
if skip: B=dp[i-1]
if solve: C=question points + points of next solvable question

dp[i]=Max(A,B,C)

how do we know if we have to skip the question?

to check if solvable we need to know the most recently solved question's brainpower and
ensure i is not in that range  


*/