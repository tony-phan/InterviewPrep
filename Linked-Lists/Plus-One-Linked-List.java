class Result {
    /*
    * Complete the 'addOne' function below.
    *
    * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
    * The function accepts INTEGER_SINGLY_LINKED_LIST A as parameter.
    */

    /*
    * For your reference:
    *
    * SinglyLinkedListNode {
    * int data;
    * SinglyLinkedListNode next;
    * }
    *
    */
    
    /*
    Understand
    input: 1 -> 2 -> 3
    output: 1 -> 2 -> 4
    
    input: 1 -> 2 -> 9
    output: 1 -> 3 -> 0
    
    Match
    Linked list
    Dummy head? We can use it but not required
    Two pointer? we don't need to use a slow/fast pointer
    Multi pass? Not needed
    
    Plan
    First reverse the list so we can start at the least significant digit (right most digit)
    Add one to the right most digit's value
    Keep track of the current sum and carry
    Traverse down the list and update the sum, carry, and node's value as needed
    Once finished traversing reverse the list again
    If the carry is greater than 0 that means we need to make a new node with the carry's value and make it the head
    return the result list
    
    Evaluate
    Time: O(n)
    Space: O(1)
    */
    public static SinglyLinkedListNode addOne(SinglyLinkedListNode A) {
        if(A == null) {
            return null;
        }
        
        SinglyLinkedListNode reversed = reverseList(A), listPointer = reversed;
        int initialSum = listPointer.data + 1;
        int carry = initialSum / 10;
        listPointer.data = initialSum % 10;
        
        listPointer = listPointer.next;
        while(listPointer != null) {
            int sum = carry + listPointer.data;
            carry = sum / 10;
            listPointer.data = sum % 10;
            listPointer = listPointer.next;
        }
        
        reversed = reverseList(reversed);
        if(carry > 0) {
            SinglyLinkedListNode carryNode = new SinglyLinkedListNode(carry);
            carryNode.next = reversed;
            reversed = carryNode;
        }
        
        return reversed;
    }
    
    private static SinglyLinkedListNode reverseList(SinglyLinkedListNode list) {
        SinglyLinkedListNode reversed = null;
        
        while(list != null) {
            SinglyLinkedListNode remainderOfList = list.next;
            list.next = reversed;
            reversed = list;
            list = remainderOfList;
        }

        return reversed;
    }
}
