public class SinglyLinkedListEmptyCheck {

    static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    // Time: O(1), Extra space: O(1)
    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        System.out.println(checkIfEmpty(null));
        System.out.println(checkIfEmpty(new Node(8)));
    }
}
