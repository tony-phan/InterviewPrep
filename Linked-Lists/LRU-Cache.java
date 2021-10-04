class LRUCache {
    /*
    Understand
    - need to maintain an ordering of which items were least recently used
    - for get and put operations, we want to always want to update the LRU ordering
    - get operation: always check if the key exists
    - put: always check cache size and if the key exists
    
    Match
    HashMap: can be used to store items with a key-value mapping
    Doubly Linked list : used to keep the LRU ordering of the cache
    
    Plan
    get:    if the key exists
                get reference of the node we're using
                remove it from the current lru ordering
                add it to the head (it's now the most recently used node)
                return the value of a node
            else
                return -1
    put:  if the key exists
            update the value of the key
            remove it from the current lru ordering
            add it to the head (it's now the most recently used node)
          else
            create a new node with the key&value arguments
            if map.size < capacity
                insert into the map
                add the node to the head (it's now the most recently used node)
            else
                remove the last node of the lru list and from the map
                add the new node into the map
                add the new node to the head (it's now the most recently used node)
    
    Evaluate
    Time: get - O(1)
          put - O(1)
    Space: O(n)
    */  
    
    Map<Integer, DoublyListNode> map;
    DoublyListNode head;
    DoublyListNode tail;
    Integer capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DoublyListNode(-1, -1);
        tail = new DoublyListNode(-1, -1);
        
        head.next = tail;
        tail.previous = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        else {
            DoublyListNode node = map.get(key);     // get reference to node we're using
            remove(node);                           // remove that node from the lru ordering
            add(node);                              // add that node to the head of the list (it's now the most recently used)
            return (map.get(key)).value;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            DoublyListNode node = new DoublyListNode(key, value);
            if(map.size() < capacity) {
                map.put(key, node);
                add(node);
            }
            else {
                // remove the tail of the lru and remove it from the map as well
                DoublyListNode lastNode = tail.previous;
                remove(lastNode);
                map.remove(lastNode.key);
                // add the new key & value to the map and add a new node to the front of the list
                map.put(key, node);
                add(node);
            }
        }
        else {
            // update the key's value
            DoublyListNode node = map.get(key);
            node.value = value;
            // move the node with that key to front of list
            remove(node);
            add(node);
        }
    }
    
    // add to the head of the list
    private void add(DoublyListNode node) {
        node.previous = head;
        node.next = head.next;
        
        head.next.previous = node;
        head.next = node;
    }
    
    // remove the node from the list
    private void remove(DoublyListNode node) {
        DoublyListNode nextNode = node.next;
        DoublyListNode previousNode = node.previous;
        
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
    }
    
    class DoublyListNode {
        int key;
        int value;
        DoublyListNode previous;
        DoublyListNode next;
        
        public DoublyListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
