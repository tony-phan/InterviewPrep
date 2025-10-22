public class Solution
{
    public int MinCost(string colors, int[] neededTime)
    {
        int n = colors.Length;

        int streakMax = neededTime[0];
        int streakSum = neededTime[0];
        int result = 0;
        for (int i = 1; i < colors.Length; ++i)
        {
            char current = colors[i];
            char prev = colors[i - 1];
            if (Colorful(current, prev))
            {
                result += (streakSum - streakMax);
                streakMax = neededTime[i];
                streakSum = neededTime[i];
            }
            else
            {
                streakSum += neededTime[i];
                streakMax = Math.Max(neededTime[i], streakMax);
            }
        }
        result += (streakSum - streakMax); // don't forget to add the sum of the last streak
        return result;
    }

    private bool Colorful(char a, char b)
    {
        return a != b;
    }
}

/*
colors = "abaac", neededTime = [1,2,3,4,5]
              i
dp = [0,0,0,3,3]
result = 3

if not colorful
    dp[i] = dp[i-1] + min(neededTime[i],neededTime[i-1])
else
    dp[i] = dp[i-1]



colors = "abc", neededTime = [1,2,3]
            i
dp = [0,0,0]
result = 0


colors = "aabaa", neededTime = [1,2,3,4,1]
              i
dp = [0,1,1,1,2]
result = 2

colors = "aaabbbabbbb", neededTime = [3,5,10,7,5,3,5,5,4,8,1]
                   i                                     i
dp = [0,3,8,8,13,16,16,16,20]
result = 
*/