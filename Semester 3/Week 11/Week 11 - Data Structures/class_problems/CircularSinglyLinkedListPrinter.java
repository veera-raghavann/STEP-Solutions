public class CircularSinglyLinkedListPrinter {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Time: O(n), Extra space: O(1)
    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        first.next = second;
        second.next = third;
        third.next = first;

        printCircular(first);
        printCircular(null);
    }
}
