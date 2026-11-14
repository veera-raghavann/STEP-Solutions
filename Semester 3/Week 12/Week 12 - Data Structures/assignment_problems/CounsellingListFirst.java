public class CounsellingListFirst {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }

    // Time: O(n), Extra space: O(1). Both groups retain their original relative order.
    public static Node partition(Node head, int passMark) {
        Node belowHead = null, belowTail = null, restHead = null, restTail = null;
        while (head != null) {
            Node next = head.next; head.next = null;
            if (head.data < passMark) {
                if (belowHead == null) belowHead = belowTail = head; else { belowTail.next = head; belowTail = head; }
            } else {
                if (restHead == null) restHead = restTail = head; else { restTail.next = head; restTail = head; }
            }
            head = next;
        }
        if (belowHead == null) return restHead;
        belowTail.next = restHead;
        return belowHead;
    }

    private static void print(Node head) { while (head != null) { System.out.print(head.data + " -> "); head = head.next; } System.out.println("null"); }
    public static void main(String[] args) {
        Node head = new Node(55); head.next = new Node(32); head.next.next = new Node(78); head.next.next.next = new Node(20); head.next.next.next.next = new Node(40); head.next.next.next.next.next = new Node(35);
        print(partition(head, 40));
    }
}
