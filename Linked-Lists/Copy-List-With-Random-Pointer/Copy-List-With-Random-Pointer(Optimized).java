/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
    head = [[1,2],[3, null],[7,0]]
    output: [[1,2],[3,null],[7,0]]
    
    head = [[5,null]]
    output: [[5,null]]
    
    Match:
    Dummy head? Yes, to hold reference to solution list
    multiple pass? Maybe could be used to get references for random pointers
    two pointer? No
    
    Plan: 
    head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
           [[7,null],[13, new ListNode(7)],[11,new ListNode(1)],[10,new ListNode(11)],[1,new ListNode(11)]]        
            HashMap: old ListNode(7) -> new ListNode(7)
                     old ListNode(13) -> new ListNode(13)
                     old ListNode(11) -> new ListNode(11)
                     old ListNode(1) -> new ListNode(1)
                     old ListNode(10) -> new ListNode(10)
                     
    Do 2 passes through the input list
    1st pass: reconstruct the list with new nodes (ignore the random pointers)
              store old node with new nodes in a hashmap
    2nd pass: traverse the old list again and check for the random node for each node we're at
              if the random is null, set the random for the new node to null
              if the random is not null, use the hashmap to get the reference to the random of the new list and set that as the random of the current node we're at
    
    Time: O(2n) = O(n)
    Space: O(2n) = O(n)
    */
    
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node dummyHead = new Node(-1), currentNode = dummyHead, listPointer = head;
        while(listPointer != null) {
            Node node = new Node(listPointer.val);
            currentNode.next = node;
            map.put(listPointer, node);
            
            currentNode = currentNode.next;
            listPointer = listPointer.next;
        }
        
        listPointer = head;
        currentNode = dummyHead.next;
        
        while(listPointer != null) {
            Node oldListRandom = listPointer.random;
            
            if(oldListRandom == null) {
                currentNode.random = null;
            }
            else {
                currentNode.random = map.get(oldListRandom);
            }
            
            currentNode = currentNode.next;
            listPointer = listPointer.next;
        }
        
        return dummyHead.next;
    }
}
