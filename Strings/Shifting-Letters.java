class Solution {
    /*
    Understand
    We are given a string of lowercase letters and an int array as input
    For each number in the array at some position "i", we want to shift the first "i" letters in the string by shifts[i] times
    Return the final string after all shifts are applied
    
    Example: s = "abc", shifts = [3, 5, 9]
             output = "rpl" 
            We start with "abc"
            After shifting the first 1 letters of s by 3, we have "dbc".
            After shifting the first 2 letters of s by 5, we have "igc".
            After shifting the first 3 letters of s by 9, we have "rpl", the answer.

    Notes: the range of shifts[i] is 0 <= shifts[i] <= 10^9, shifts[i] could possibly be a huge number, so we'll have to use modolus to get the net total shifts since there are only a total of 26 letters
           we can calculate the total net shifts for a position by doing a reverse prefix sum of the shifts array
           Example: Total net shifts for shifts = [3,5,9] is [17,14,9] because [3+5+9,5+9,9]
           if the shift goes beyond 'z', we want to wrap around and start at 'a'
    
    Match
    String & Array problem
    Prefix sum
    
    Plan
    First we calculate the total net shifts for each shift in shifts by doing % 26 on every shift since shifts[i] could be a very large number
    Then we do a reverse prefix sum on shifts to get the total shifts for each position
    Now we apply shifts[i] to each letter in the string
    for each shifts[i], add it to the ascii int value of the current letter
        if the sum is greater than (int)'z', then we want to wrap around and start at 'a'
            calculate how many values the sum is over (int)'z' and add it to (int)'a' - 1.
            the sum is the ascii value of the final result character
        add the final result character to the result
    return the resulting string
    
    Evaluate
    Time: O(N)
    Space: O(N)
    */
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for(int i = shifts.length - 2; i >= 0; --i) {
            int current = shifts[i] % 26;
            int right = shifts[i + 1];
            shifts[i] = (current + right) % 26;
        }
                
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int newAscii = (int)c + shifts[i];
            if(newAscii > (int)'z') {
                int leftOver = newAscii - (int)'z';
                newAscii = ((int)'a' + leftOver) - 1;
            }
            result.append((char)newAscii);
        }
        return result.toString();
    }
}
// ASCII: a(97) - z(122)
