public class LastButKAnnouncement {
    static class Node { String data; Node next; Node(String data) { this.data = data; } }

    // Time: O(n), Extra space: O(1); unlike a length-counting solution, this needs one pass.
    public static String kthFromEnd(Node head, int k) {
        Node lead = head;
        for (int i = 0; i < k; i++) { if (lead == null) return null; lead = lead.next; }
        Node trail = head;
        while (lead != null) { lead = lead.next; trail = trail.next; }
        return trail.data;
    }

    public static void main(String[] args) {
        Node head = new Node("301"); head.next = new Node("302"); head.next.next = new Node("303"); head.next.next.next = new Node("304"); head.next.next.next.next = new Node("305"); head.next.next.next.next.next = new Node("306");
        String answer = kthFromEnd(head, 2);
        System.out.println(answer == null ? "Invalid k" : "2 from the end: " + answer);
    }
}
