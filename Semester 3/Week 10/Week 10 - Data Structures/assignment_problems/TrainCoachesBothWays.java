public class TrainCoachesBothWays {

    private static class Node {
        String name;
        Node previous;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    private Node head;
    private Node tail;

    public void addLast(String name) {
        Node node = new Node(name);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public boolean remove(String name) {
        Node current = head;

        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current.previous == null) {
            head = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            tail = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return true;
    }

    public void printForward() {
        System.out.print("Forward: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        System.out.print("Backward: ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.name);
            if (current.previous != null) {
                System.out.print(" <-> ");
            }
            current = current.previous;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");
        train.printForward();
        train.printBackward();
    }
}

// Finding a coach: O(n); unlinking after finding it: O(1).
