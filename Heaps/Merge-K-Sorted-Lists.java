/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    Match
    Heap: can be used to order all the values in all the linked lists
    
    Plan
    Loop through all the lists and add the nodes into a heap
    create a result list from all the elements in the heap
    
    Evaluate:
    Time: O(n * m)
    	 n is the # of lists, m is the size of each list
    Space: O(n * m)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        
        for(ListNode list : lists) {
            ListNode current = list;
            
            while(current != null) {
                heap.add(current);
                current = current.next;
            }
        }
        
        ListNode dummyPointer = dummy;
        while(!heap.isEmpty()) {
            dummyPointer.next = heap.poll();
            dummyPointer = dummyPointer.next;
            dummyPointer.next = null;
        }
        return dummy.next;
    }
}
