package game;

// Class representing a player in the game
public class Player {
    
    private int id; // Unique identifier for the player
    private int score; // The player's score
    private boolean lastWasSixes = false; // Flag indicating if the last dice roll was two sixes

    /**
    * The constructor of the Player class 
    * It initializes the player with a given id and default score of 0
    */
    public Player(int id){
        this.id = id;
        score = 0;
    }

    // Getter method for the player's id
    public int getId(){
        return id;
    }

    // Getter method for the player's score
    public int getScore(){
        return score;
    }

    // Setter method to update the player's score
    public void setScore(int score){
        this.score = score;
    }
    // Getter method to check if the player's last roll was two sixes
    public boolean getLastWasSixes(){
        return lastWasSixes;
    }

    // Setter method to update whether the player's last roll was two sixes
    public void setLastWasSixes(boolean lastWasSixes){
        this.lastWasSixes = lastWasSixes;
    }
}
