package game;

public class RaffleCup {
    // Array to store two dice
    private Die[] dice;

    // Constructor initializes the array with two new Die objects
    public RaffleCup() {
        dice = new Die[2];   // Create an array of two dice
        dice[0] = new Die(); // Initialize the first die
        dice[1] = new Die(); // Initialize the second die
    }

    // Returns the face value of the die at the specified index
    public int getValue(int index) {
        return dice[index].getFaceValue(); // Get the face value of the die at the given index
    }

    // Rolls both dice
    public void roll() {
        dice[0].roll(); // Roll the first die
        dice[1].roll(); // Roll the second die
    }

    // Returns the sum of the face values of both dice
    public int getSum() {
        return dice[0].getFaceValue() + dice[1].getFaceValue(); // Get the sum of both dice
    }

    // Checks if both dice have the same face value
    public boolean isSame() {
        return dice[0].getFaceValue() == dice[1].getFaceValue(); // Return true if both dice show the same value
    }
}