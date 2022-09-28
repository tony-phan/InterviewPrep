class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
        To know the lengths of each partitions we have to get the index of the last occurance of each character
        after that, scan the input string
        as we go throught each letter we want to find the end of the partition
        partition end = max(last index of current letter, current end)
        if current index == end, then we are at the end of the partition
        partition size = end - start + 1
        set start to next index (start = end + 1)
        
        
        Time: O(N)
        Space: O(1)
        */
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int[] lastIndexes = new int[26];
        
        for(int i = 0; i < n; ++i) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        for(int i = 0 ; i < n; ++i) {
            char letter = s.charAt(i);
            end = Math.max(end, lastIndexes[letter - 'a']);
            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
