package game;

/**
 * A Classical 6-sided Die.
 */
public class Die {
    /**
     * Initial face value of the die.
     */
    private int faceValue = 1;

    /**
     * Constructor of the Die class.
     * <br>
     * We use the roll() method to get a random face value to reflect the
     * real-world randomization of first starting using a die in a
     * game.
     */
    public Die() {
        roll();
    }

    /**
     * Rolls the 6-sided die, updating its face value based on a uniform
     * distribution.
     */
    public void roll() {
        faceValue = (int) (Math.random() * 6) + 1;
    }

    /**
     * @return the face value of the die
     */
    public int getFaceValue() {
        return faceValue;
    }
}

