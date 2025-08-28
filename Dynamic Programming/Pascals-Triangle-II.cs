public class Solution
{
    public IList<int> GetRow(int rowIndex)
    {
        int numRows = rowIndex + 1;

        int[] row = new int[] { 1 };
        for (int r = 1; r < numRows; ++r)
        {
            int[] newRow = new int[r + 1];
            for (int col = 0; col < newRow.Length; ++col)
            {
                if (col == 0 || col == newRow.Length - 1)
                {
                    newRow[col] = 1;
                    continue;
                }
                newRow[col] = row[col - 1] + row[col];
            }
            row = newRow;
        }
        return row.ToList();
    }
}

/*

[1]
[1,1]
[1,2,1]
[1,3,3,1]
[1,4,6,4,1]
[1,5,10,10,5,1]
[1,6,15,20,15,6,1]
[1,7,21,35,35,21,7,1] 7

*/