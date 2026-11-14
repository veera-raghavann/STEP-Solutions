public class MergeTwoWaitlists {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }

    // Time: O(m + n), Extra space: O(1), using only one dummy node.
    public static Node merge(Node first, Node second) {
        Node dummy = new Node(0), tail = dummy;
        while (first != null && second != null) {
            if (first.data <= second.data) { tail.next = first; first = first.next; }
            else { tail.next = second; second = second.next; }
            tail = tail.next;
        }
        tail.next = first != null ? first : second;
        return dummy.next;
    }

    private static void print(Node head) { while (head != null) { System.out.print(head.data + " -> "); head = head.next; } System.out.println("null"); }
    public static void main(String[] args) {
        Node first = new Node(3); first.next = new Node(8); first.next.next = new Node(15);
        Node second = new Node(5); second.next = new Node(8); second.next.next = new Node(20); second.next.next.next = new Node(25);
        print(merge(first, second));
    }
}
