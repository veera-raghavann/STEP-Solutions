public class CircularSinglyLinkedListEndInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Time: O(n), Extra space: O(1)
    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }

        newNode.next = head;
        tail.next = newNode;
        return head;
    }

    private static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;
        third.next = first;

        printCircular(insertAtEndCircular(first, 4));
        printCircular(insertAtEndCircular(null, 9));
    }
}
