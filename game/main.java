package game;

/** 
 * Class for the entry point of the program.
 */
class Program {
    /** 
     * Main function of the program.
     * Creates and starts the game.
     */
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.Play();
    }
}

/** 
 * Class for the main game flow and connecting every part of the project.
 */
class DiceGame {
    private Player[] players;
    private RaffleCup raffleCup;
    private java.util.Scanner scanner;

    /**
     * Constructor of the DiceGame class.
     * We create the input scanner, player and rafflecup objects.
     */
    public DiceGame() {
        scanner = new java.util.Scanner(System.in);

        players = new Player[2];
        players[0] = new Player(1);
        players[1] = new Player(2);

        raffleCup = new RaffleCup();
    }

    /**
     * Starts and plays through the entire game loop.
     */
    public void Play() {
        // Reset the score of every player, in case the game was restarted.
        for(var player : players) player.setScore(0);

        // Usecase 1 step 2: Randomly selecting the starting player
        int currentPlayerIndex = (int) (Math.random() * 2);
        Player currentPlayer = players[currentPlayerIndex];

        // Game loop (one run through the loop is a single player turn)
        boolean playing = true;
        while(playing) {
            // Usecase 1 step 3: Rolling the dice.
            System.out.println("Player " + currentPlayer.getId() + " press enter to roll the dice.");
            scanner.nextLine();
            raffleCup.roll();
            // Usecase 1 step 4: Displaying feedback from dice rolls.
            int sum = raffleCup.getSum();
            int value1 = raffleCup.getValue(0);
            int value2 = raffleCup.getValue(1);
            System.out.println("Die 1 value: " + value1);
            System.out.println("Die 2 value: " + value2);
            System.out.println("Total value: " + sum);

            // Usecase 1 step 5: Checking the dice and updating the game state according to the game rules.
            boolean playerWon = false;
            // Usecase 1 step 5.ii: Winning by rolling two 6's twice in a row.
            if(value1 == 6 && value2 == 6) {
                if(currentPlayer.getLastWasSixes()) {
                    playerWon = true;
                    System.out.println("Player " + currentPlayer.getId() + " won the game, by rolling two 6's twice in a row!");
                }
                currentPlayer.setLastWasSixes(true);
            } else {
                currentPlayer.setLastWasSixes(false);
            }
            //   Usecase 1 step 5.iii: Winning by rolling two of the same after reaching 40 points.
            if(currentPlayer.getScore() >= 40 && raffleCup.isSame() && !(value1 == 1 && value2 == 1)) {
                playerWon = true;
                System.out.println("Player " + currentPlayer.getId() + " won the game, by rolling two of the same after reaching 40 points!");
            }
            //   Usecase 1 step 5.i: Updating the score, and resetting to 0 by rolling two 1's:
            if(value1 == 1 && value2 == 1) {
                currentPlayer.setScore(0);
            } else {
                currentPlayer.setScore(currentPlayer.getScore() + sum);
            }

            // Usecase 1 step 6: Displaying the updated game state.
            System.out.println("Player 1 score: " + players[0].getScore());
            System.out.println("Player 2 score: " + players[1].getScore());
            if(playerWon) System.out.println("Player " + currentPlayer.getId() + " won the game!");
            
            // If the player won, end the game
            if(playerWon) {
                playing = false;
            }
            // Pick the next player and repeat loop
            else {
                //  Usecase 1 step 5.iv: Player gets another turn by rolling two of the same
                if(raffleCup.isSame() == false) {
                    // Change next player
                    if(currentPlayerIndex == 0) currentPlayerIndex = 1;
                    else currentPlayerIndex = 0;
                    currentPlayer = players[currentPlayerIndex];
                }
            }
        }
        // Usecase 1 step 7: Game ended. Let players choose to restart or end program.
        boolean decided = false;
        while(!decided) {
            System.out.println("Do you want to play again? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();
            //Play game again
            if(answer.equals("yes")) {
                decided = true;
                Play();
            }
            //Leave function
            else if(answer.equals("no")) {
                decided = true;
            }
            //Ask again
            else {
                System.out.println("Unrecognized answer");
            }
        }
    }
}