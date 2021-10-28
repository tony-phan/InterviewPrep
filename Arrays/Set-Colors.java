class Solution {
    public void sortColors(int[] nums) {
        /*
        Understand
        We are given an int array as input
        the arrya only contains 0(red),1(white),and 2(blue)
        Sort the array in-place so that the array is in the order of red(0),white(1),blue(2)
        You cannot use Arrays.sort()
        Example: input = [2,0,2,1,1,0]
                 output: [0,0,1,1,2,2]
        
        Match
        Array & Sorting problem
        Counting Sort
        
        Plan
        Use a hashmap to store the frequencies of 0, 1, and 2
        use a int variable to store current index of array (starting at 0)
        for each value from 0 to 2 (x)
            get its frequency
            for num frequencies
                set the current value of the array at the index we're at to x
                index += 1
        
        Evaluate
        Time: O(N)
        Space: O(1) because the map will only be of finite size
        */
        Map<Integer, Integer> map = new HashMap<>();
        /*
        Map
        0 - 2
        1 - 2
        2 - 2
        */
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int index = 0;
        for(int i = 0; i < 3; ++i) {
            int count = map.get(i);
            for(int j = 0; j < count; ++j) {
                nums[index] = i;
                ++index;
            }
        }
    }
}
