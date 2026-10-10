public class RoundRobinGameTurns {

    private static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    private Node tail;

    public void addLast(String name) {
        Node node = new Node(name);

        if (tail == null) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
    }

    public void printTurns(int turns) {
        if (tail == null) {
            throw new IllegalStateException("No players have been added");
        }
        if (turns < 1) {
            throw new IllegalArgumentException("turns must be positive");
        }

        Node current = tail.next;
        for (int turn = 0; turn < turns; turn++) {
            if (turn > 0) {
                System.out.print(" ");
            }
            System.out.print(current.name);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinGameTurns game = new RoundRobinGameTurns();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");
        game.printTurns(7);
    }
}

// addLast: O(1) with tail; printing t turns: O(t).
