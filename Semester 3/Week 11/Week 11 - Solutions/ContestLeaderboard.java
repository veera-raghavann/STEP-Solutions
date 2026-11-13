public class ContestLeaderboard {

    static class Entry {
        String studentName;
        int marks;

        Entry(String studentName, int marks) {
            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }
            this.studentName = studentName;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return studentName + " " + marks;
        }
    }

    /*
     * Time complexity: O(n + 101)
     * Extra space: O(n + 101)
     * Stable: Yes, placing entries from right to left preserves submission order for equal marks.
     */
    public static Entry[] leaderboard(Entry[] entries) {
        int[] counts = new int[101];
        Entry[] sortedEntries = new Entry[entries.length];

        for (Entry entry : entries) {
            counts[100 - entry.marks]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = entries.length - 1; i >= 0; i--) {
            Entry entry = entries[i];
            int key = 100 - entry.marks;
            sortedEntries[--counts[key]] = entry;
        }

        return sortedEntries;
    }

    public static void main(String[] args) {
        Entry[] entries = {
                new Entry("Asha", 90),
                new Entry("Ravi", 75),
                new Entry("Neha", 90),
                new Entry("Kiran", 100),
                new Entry("Meera", 75)
        };

        Entry[] leaderboard = leaderboard(entries);
        for (Entry entry : leaderboard) {
            System.out.println(entry);
        }
    }
}
