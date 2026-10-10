public class ReverseTheQueue {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private static Node buildList(int... values) {
        Node head = null;
        Node tail = null;

        for (int value : values) {
            Node node = new Node(value);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node queue = buildList(1, 2, 3, 4);
        printList(reverse(queue));

        Node singlePersonQueue = buildList(9);
        printList(reverse(singlePersonQueue));

        Node emptyQueue = buildList();
        printList(reverse(emptyQueue));
    }
}

// Time: O(n); additional space: O(1).
// Reverses the existing links in place without creating any new nodes.
