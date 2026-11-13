public class DoublyLinkedListTailInsertion {

    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
        }
    }

    // Time: O(n), Extra space: O(1)
    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);

        if (head == null) {
            return newNode;
        }

        DNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }

    private static void printForward(DNode head) {
        for (DNode current = head; current != null; current = current.next) {
            System.out.print(current.data + (current.next == null ? "" : " <-> "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        printForward(insertAtTailDoubly(head, 4));
        printForward(insertAtTailDoubly(null, 7));
    }
}
