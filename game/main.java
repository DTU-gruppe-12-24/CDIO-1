package game;

class Program {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.main();
    }
}

class DiceGame {
    private Player[] players;
    private RaffleCup raffleCup;
    private java.util.Scanner scanner;

    public DiceGame() {
        scanner = new java.util.Scanner(System.in);

        players = new Player[2];
        players[0] = new Player(1);
        players[1] = new Player(2);

        raffleCup = new RaffleCup();
    }

    public void main() {
        //reset score
        for(var player : players) player.setScore(0);
        //2. Select starting player
        int currentPlayerIndex = (int) (Math.random() * 2);
        Player currentPlayer = players[currentPlayerIndex];
        //Player turn
        boolean playing = true;
        while(playing) {
            //3. Roll the dice
            System.out.println("Player " + currentPlayer.getId() + " press enter to roll the dice.");
            scanner.nextLine();
            raffleCup.roll();
            //4. Feedback
            int sum = raffleCup.getSum();
            int value1 = raffleCup.getValue(0);
            int value2 = raffleCup.getValue(1);
            System.out.println("Die 1 value: " + value1);
            System.out.println("Die 2 value: " + value2);
            System.out.println("Total value: " + sum);
            //5. Rules
            boolean playerWon = false;
            //  ii.
            if(value1 == 6 && value2 == 6) {
                if(currentPlayer.getLastWasSixes()) {
                    playerWon = true;
                    System.out.println("Player " + currentPlayer.getId() + " won the game, by rolling two 6's twice in a row!");
                }
                currentPlayer.setLastWasSixes(true);
            } else {
                currentPlayer.setLastWasSixes(false);
            }
            //  iii.
            if(currentPlayer.getScore() >= 40 && raffleCup.isSame() && !(value1 == 1 && value2 == 1)) {
                playerWon = true;
                System.out.println("Player " + currentPlayer.getId() + " won the game, by rolling two of the same after reaching 40 points!");
            }
            //  i. update score
            if(value1 == 1 && value2 == 1) {
                currentPlayer.setScore(0);
            } else {
                currentPlayer.setScore(currentPlayer.getScore() + sum);
            }
            //6. Feedback
            System.out.println("Player 1 score: " + players[0].getScore());
            System.out.println("Player 2 score: " + players[1].getScore());
            if(playerWon) System.out.println("Player " + currentPlayer.getId() + " won the game!");
            //Continue
            if(playerWon) {
                playing = false;
            } else {
                //  5.iv.
                if(raffleCup.isSame() == false) {
                    if(currentPlayerIndex == 0) currentPlayerIndex = 1;
                    else currentPlayerIndex = 0;
                    currentPlayer = players[currentPlayerIndex];
                }
            }
        }
        //7. Restart?
        boolean decided = false;
        while(!decided) {
            System.out.println("Do you want to play again? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();
            if(answer.equals("yes")) {
                decided = true;
                main();
            } else if(answer.equals("no")) {
                decided = true;
            } else {
                System.out.println("Unrecognized answer");
            }
        }
    }
}