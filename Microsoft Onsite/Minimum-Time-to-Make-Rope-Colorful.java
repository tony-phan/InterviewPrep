class Solution {
    /*
    Plan
    We want to check every adjacent pair of balloons on the rope
    If two adjacent balloons have the same color we want to remove one of them
    Remove the balloon with the less needed time to remove it (minimum)
    Overwrite the needed time of both balloons to the max needed time of the two balloons
    continue on to the next pair
    
    Match
    Dynamic Programming
    
    Evaluate
    Time: O(n)
    Space: O(1)
    */
    public int minCost(String colors, int[] neededTime) {
        if(colors.length() < 2) {
            return 0;
        }
        
        int result = 0;
        int i = 0;
        while(i < colors.length() - 1) {
            String pair = colors.substring(i, i + 2);
            if(pair.charAt(0) == pair.charAt(1)) {
                result += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
            ++i;
        }
        return result;
    }
}
