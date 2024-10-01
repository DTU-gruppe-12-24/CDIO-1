package game;

public class Die {
    private int faceValue = 1;

    /**
     * Constructor of the Die class. We utilize the roll() method to get a random
     * face value
     * to reflect the real-world randomization of first starting using a die in a
     * game.
     */
    public Die() {
        roll();
    }

    /**
     * Rolls the die, updating its private attribute faceValue
     * to a random number between 1 and 6, utilizing the Math.random() method
     * which returns a double between 0.0 and 1.0.
     */
    public void roll() {
        faceValue = (int) (Math.random() * 6) + 1;
    }

    /**
     * Returns the face value of the die.
     *
     * @return the face value of the die
     */
    public int getFaceValue() {
        return faceValue;
    }
}

