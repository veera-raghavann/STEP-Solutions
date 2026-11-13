public class SplitSinglyLinkedListInHalf {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Time: O(n), Extra space: O(1)
    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // slow finishes at the final node of the first half.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;
        return secondHalf;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + (head.next == null ? "" : " -> "));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node secondHalf = splitListInHalf(head);
        System.out.print("First half: ");
        printList(head);
        System.out.print("Second half: ");
        printList(secondHalf);
    }
}
