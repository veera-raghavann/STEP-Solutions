public class MiddleSeatFinder {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }

    // Time: O(n), Extra space: O(1). The fast pointer visits approximately n/2 nodes.
    public static int middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        return slow.data;
    }

    public static void main(String[] args) {
        Node head = new Node(11); head.next = new Node(22); head.next.next = new Node(33); head.next.next.next = new Node(44); head.next.next.next.next = new Node(55); head.next.next.next.next.next = new Node(66);
        System.out.println("Middle: " + middle(head));
    }
}
