public class Solution
{
    public IList<IList<int>> Generate(int numRows)
    {
        var result = new List<IList<int>> {
            new List<int> { 1 }
        };

        for (int i = 1; i < numRows; ++i)
        {
            int[] prevRow = result[i - 1].ToArray();
            int[] row = new int[i + 1];
            for (int j = 0; j < row.Length; ++j)
            {
                if (j == 0 || j == row.Length - 1)
                {
                    row[j] = 1;
                    continue;
                }
                row[j] = prevRow[j - 1] + prevRow[j];
            }
            result.Add(row.ToList());
        }
        return result;
    }
}

/*
numRows = 5

result = [[1],]

row 1 = [1]
row 2 = [1,1]
row 3 = [1,2,1]
row 4 = [1,3,3,1]
row 5 = [1,4,6,4,1]
row 6 = [1,5,10,10,5,1]
row 7 = [1,x,x,x,x,x,x]
           j
.
.
.
row i

at index j,
    s = sum of 2 #'s above (row[i-1][j-1] + row[i-1][j])
    row[i][j] = s

x = row[i-1][j-1] + row[i-1][j]
*/