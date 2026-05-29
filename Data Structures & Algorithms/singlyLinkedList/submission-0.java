class LinkedList {
    // 1. Define what a single "Train Car" (Node) looks like
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // 2. Initialize an empty linked list
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 3. Get the value at a specific index
    public int get(int index) {
        // Out of bounds check
        if (index < 0 || index >= size) {
            return -1;
        }

        // Start at the head and hop 'index' times
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // 4. Insert a new node at the very front
    public void insertHead(int val) {
        Node newNode = new Node(val);
        
        if (size == 0) {
            // If empty, this new node is both head and tail
            head = newNode;
            tail = newNode;
        } else {
            // Point new node to old head, then make it the new head
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // 5. Insert a new node at the very back
    public void insertTail(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            // If empty, same logic as insertHead
            head = newNode;
            tail = newNode;
        } else {
            // Tell current tail to point to new node, then update tail reference
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // 6. Remove a node at a specific index
    public boolean remove(int index) {
        // Out of bounds check
        if (index < 0 || index >= size) {
            return false;
        }

        // Case A: Removing the head node
        if (index == 0) {
            head = head.next;
            if (head == null) { // If the list is now empty, tail must be null too
                tail = null;
            }
        } 
        // Case B: Removing any other node
        else {
            // Move a pointer to the node right BEFORE the one we want to delete
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            
            // Skip the deleted node
            current.next = current.next.next;
            
            // If we just deleted the old tail, update our tail reference
            if (current.next == null) {
                tail = current;
            }
        }

        size--;
        return true;
    }

    // 7. Walk the list and return all values in an ArrayList
    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;
        
        // Loop until current hits null (end of the list)
        while (current != null) {
            values.add(current.val);
            current = current.next; // Move to the next node
        }
        
        return values;
    }
}