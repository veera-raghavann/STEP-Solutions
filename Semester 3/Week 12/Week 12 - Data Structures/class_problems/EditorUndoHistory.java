public class EditorUndoHistory {
    static class Editor {
        private final String[] history;
        private int top = -1;

        Editor(int capacity) { history = new String[capacity]; }

        // TYPE is O(1); UNDO is O(1). Printing is O(n).
        void type(String word) {
            if (top == history.length - 1) {
                System.out.println("rejected: history full");
                return;
            }
            history[++top] = word;
            printHistory();
        }

        void undo() {
            if (top == -1) {
                System.out.println("rejected: nothing to undo");
                return;
            }
            top--;
            printHistory();
        }

        private void printHistory() {
            if (top == -1) {
                System.out.println("(empty)");
                return;
            }
            for (int i = 0; i <= top; i++) System.out.print(history[i] + (i == top ? "\n" : " "));
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor(3);
        editor.type("Hi"); editor.type("there"); editor.type("all"); editor.type("now");
        editor.undo(); editor.undo(); editor.undo(); editor.undo();
    }
}
