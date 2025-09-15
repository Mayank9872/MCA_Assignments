import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) return "Rock";
        else if (rand < 0.66) return "Paper";
        else return "Scissors";
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) return "Draw";
        if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[3][2];
        stats[0][0] = "Player Wins"; stats[0][1] = String.valueOf(playerWins);
        stats[1][0] = "Computer Wins"; stats[1][1] = String.valueOf(computerWins);
        stats[2][0] = "Winning %";
        stats[2][1] = String.format("Player: %.2f%%, Computer: %.2f%%",
                        (playerWins * 100.0) / totalGames,
                        (computerWins * 100.0) / totalGames);
        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.printf("%-10s %-12s %-12s %-10s%n", "Game", "Player", "Computer", "Winner");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s %-12s %-12s %-10s%n", 
                              "Game " + (i+1), gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }

        System.out.println("\nStatistics:");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-15s : %s%n", stats[i][0], stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[][] gameResults = new String[n][3];
        int playerWins = 0, computerWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (Rock, Paper, Scissors) for Game " + (i+1) + ": ");
            String playerChoice = sc.nextLine();
            String computerChoice = getComputerChoice();

            String winner = findWinner(playerChoice, computerChoice);
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(playerWins, computerWins, n);
        displayResults(gameResults, stats);

        sc.close();
    }
}
