public class BrowserTabStrip {
    static class Tab { String name; Tab prev, next; Tab(String name) { this.name = name; } }
    private Tab head, current;

    // OPEN and CLOSE are O(1); BACK and FORWARD are O(1).
    public void open(String name) {
        Tab tab = new Tab(name);
        if (head == null) head = current = tab;
        else { tab.prev = current; tab.next = current.next; if (current.next != null) current.next.prev = tab; current.next = tab; current = tab; }
        printStrip("OPEN " + name);
    }
    public void close() {
        if (current == null) { System.out.println("CLOSE: no tabs"); return; }
        String name = current.name; Tab replacement = current.next != null ? current.next : current.prev;
        if (current.prev != null) current.prev.next = current.next; else head = current.next;
        if (current.next != null) current.next.prev = current.prev;
        current = replacement; printStrip("CLOSE " + name);
    }
    public void back() { if (current == null || current.prev == null) System.out.println("BACK: already at first tab"); else { current = current.prev; printStrip("BACK"); } }
    public void forward() { if (current == null || current.next == null) System.out.println("FORWARD: already at last tab"); else { current = current.next; printStrip("FORWARD"); } }
    public void printBackward() { Tab tail = head; if (tail == null) { System.out.println("Backward: (empty)"); return; } while (tail.next != null) tail = tail.next; System.out.print("Backward: "); for (; tail != null; tail = tail.prev) System.out.print(tail.name + (tail.prev == null ? "\n" : " <-> ")); }
    private void printStrip(String command) { System.out.print(command + ": "); for (Tab tab = head; tab != null; tab = tab.next) System.out.print((tab == current ? "[" + tab.name + "]" : tab.name) + (tab.next == null ? "\n" : " <-> ")); }

    public static void main(String[] args) { BrowserTabStrip tabs = new BrowserTabStrip(); tabs.open("Mail"); tabs.open("Docs"); tabs.open("Maps"); tabs.back(); tabs.back(); tabs.back(); tabs.open("Drive"); tabs.close(); tabs.forward(); tabs.close(); tabs.printBackward(); }
}
