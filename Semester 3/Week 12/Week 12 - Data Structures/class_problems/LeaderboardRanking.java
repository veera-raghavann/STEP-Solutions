public class LeaderboardRanking {
    static class Participant {
        String name; int score;
        Participant(String name, int score) { this.name = name; this.score = score; }
    }

    // Stable insertion sort: O(n^2) time, O(1) extra space. Ranking output: O(n) time.
    public static void sortByScore(Participant[] participants) {
        for (int i = 1; i < participants.length; i++) {
            Participant key = participants[i];
            int j = i - 1;
            while (j >= 0 && participants[j].score < key.score) {
                participants[j + 1] = participants[j--];
            }
            participants[j + 1] = key;
        }
    }

    public static void printRanks(Participant[] participants) {
        int rank = 0;
        for (int i = 0; i < participants.length; i++) {
            if (i == 0 || participants[i].score != participants[i - 1].score) rank = i + 1;
            System.out.println(rank + " " + participants[i].name + " " + participants[i].score);
        }
    }

    public static void main(String[] args) {
        Participant[] participants = {new Participant("Asha", 90), new Participant("Ravi", 85), new Participant("Neha", 90), new Participant("Kiran", 70)};
        sortByScore(participants); printRanks(participants);
    }
}
