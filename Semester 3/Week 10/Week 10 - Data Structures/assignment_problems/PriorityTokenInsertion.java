public class PriorityTokenInsertion {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int token) {
        Node node = new Node(token);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast(int token) {
        Node node = new Node(token);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAt(int index, int token) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (index == 0) {
            addFirst(token);
            return;
        }
        if (index == size) {
            addLast(token);
            return;
        }

        Node previous = head;
        for (int position = 0; position < index - 1; position++) {
            previous = previous.next;
        }

        Node node = new Node(token);
        node.next = previous.next;
        previous.next = node;
        size++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion tokens = new PriorityTokenInsertion();
        tokens.addLast(101);
        tokens.addLast(102);
        tokens.addLast(103);

        tokens.addFirst(100);
        tokens.addLast(104);
        tokens.insertAt(2, 150);
        tokens.printList();
    }
}

// addFirst: O(1); addLast: O(1) with tail; insertAt: O(n) in general.
