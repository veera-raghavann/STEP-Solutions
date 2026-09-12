import java.util.Random;

public class RockPaperScissorsGame {
    static String playRound(String player, String computer) {
        if (player.equalsIgnoreCase(computer)) {
            return "Draw";
        }
        boolean win = (player.equalsIgnoreCase("Rock") && computer.equals("Scissors"))
                || (player.equalsIgnoreCase("Paper") && computer.equals("Rock"))
                || (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"));
        return win ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {
            String computer = moves[random.nextInt(moves.length)];
            String result = playRound(playerMoves[i], computer);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println("Round " + (i + 1) + " | " + playerMoves[i]
                    + " | " + computer + " | " + result);
        }

        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, wins * 100.0 / playerMoves.length);
    }
}
