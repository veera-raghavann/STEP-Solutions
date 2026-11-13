public class HackathonRegistrationDesk {

    static class Team {
        String name;
        int size;

        Team(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return name + "(" + size + ")";
        }
    }

    /*
     * Time complexity: Best O(n), average/worst O(n^2)
     * Extra space: O(1)
     * Stable: Yes, because teams with equal sizes are not shifted past each other.
     */
    public static void sortTeams(Team[] teams) {
        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;

            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Team[] teams = {
                new Team("Pixel", 4),
                new Team("Byte", 2),
                new Team("Nova", 4),
                new Team("Echo", 3),
                new Team("Atom", 2)
        };

        sortTeams(teams);

        for (Team team : teams) {
            System.out.print(team + " ");
        }
    }
}
