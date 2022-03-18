class LRUCache {
    /*
    We need to store all key-value pairings (hashmap)
    We need to store the order of the most recently used keys (doubly linked list)
        - the head will point to the most recently used
        - the tail will point to the last recently used
        - anytime we add a new key-value, place it at the head
        - anytime we update a key-value, place it at the head
        - if we remove an key-value, then remove the one at the tail
    */

    Integer capacity;
    Map<Integer, DoublyLinkedNode> map;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoublyLinkedNode(-1, -1);
        tail = new DoublyLinkedNode(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DoublyLinkedNode node = map.get(key);
            remove(node);
            addToHead(node);
            
            return node.value;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            if(map.size() < capacity) {
                map.put(key, newNode);
                addToHead(newNode);
            }
            else {
                // remove the tail of the lru and remove it from the map as well
                DoublyLinkedNode lastNode = tail.prev;
                remove(lastNode);
                map.remove(lastNode.key);
                
                // add the new key & value to the map and add a new node to the front of the list
                map.put(key, newNode);
                addToHead(newNode);
            }
        }
        else {
            // update the key's value
            DoublyLinkedNode node = map.get(key);
            node.value = value;
            // move the node with that key to front of list
            remove(node);
            addToHead(node);
        }
    }
    
    private void addToHead(DoublyLinkedNode node) { // add the node to the head of the DoublyLinkedList, that node will become the most recently used key
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    private void remove(DoublyLinkedNode node) { // remove node from the DoublyLinkedList
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        
        node.prev = null;
        node.next = null;
        
        prev.next = next;
        next.prev = prev;
    }
    
    class DoublyLinkedNode {
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        int key;
        int value;
        
        public DoublyLinkedNode(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
