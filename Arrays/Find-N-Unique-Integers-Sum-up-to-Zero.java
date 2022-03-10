class Solution {
    public int[] sumZero(int n) {
        if(n == 1) {
            return new int[]{0};
        }
        
        int[] result = new int[n];
        int counter = n;
        for(int i = 0; i < result.length/2; ++i) {
            result[i] = counter;
            result[(result.length - 1) - i] = -counter;
            --counter;
        }
        return result;
    }
}

/*
Problem:
Given an integer n, return any array containing n unique integers such that they add up to 0.

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].


Approach: Return an array where the values will be symmetric (x, -x)
n = 5
[5, 4, 0, -4, -5]

n = 4
[4,3,-3,-4]
Symmetric values will cancel each other out bc their sum is 0
So if the array contains only symmetric pairings, then all values will cancel out and the entire sum will be 0

Evaluate
Time: O(n)
Space: O(n)
*/
