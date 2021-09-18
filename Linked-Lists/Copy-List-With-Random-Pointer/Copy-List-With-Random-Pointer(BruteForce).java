}
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
                     
    Traverse input list
    For each node we're at:
        check if hashmap has a mapping from old Listnode to new listNode of current node value
        if no:
            create a new node with current node value
            set new node as next node in solution list
            add mapping from old to new node in hashmap
            check if map has a mapping from old listnode's random to a node in new list
                if no:
                    create a new node with random node value
                    add mapping from old random node to new random node in hashmap
            also check if map has mapping to current list node's next node
        if yes:
            get reference of new listnode and set as next node in the solution list
            check hashmap if we have a mapping of next random node 
            if yes:
                set current node's next to the mapping of the next random node
            if no:
                create a new node with random node value
                    add mapping from old random node to new random node in hashmap
    return solution list
    
    Time: O(n)
    Space: O(2n) = O(n)
    */
    
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node dummyHead = new Node(-1), currentNode = dummyHead, listPointer = head;
        while(listPointer != null) {
            if(!map.containsKey(listPointer)) {
                Node node = new Node(listPointer.val);
                map.put(listPointer, node);
                
                currentNode.next = node;
            }
            else {
                currentNode.next = map.get(listPointer);
            }
            currentNode = currentNode.next;
            
            if(listPointer.random == null) {
                currentNode.random = null;
            }
            else {
                if(map.containsKey(listPointer.random)) {
                    currentNode.random = map.get(listPointer.random);
                }
                else {
                    Node node = new Node(listPointer.random.val);
                    map.put(listPointer.random, node);
                    
                    currentNode.random = node;
                }
            }
            
            listPointer = listPointer.next;
        }
        
        return dummyHead.next;
    }
}
