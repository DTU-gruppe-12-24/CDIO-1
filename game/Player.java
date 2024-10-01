package game;

public class Player {
    
    private int id;
    private int score;
    private boolean lastWasSixes = false;

    public Player(int id){
        this.id = id;
        score = 0;
    }

    public int getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public boolean getLastWasSixes(){
        return lastWasSixes;
    }

    public void setLastWasSixes(boolean lastWasSixes){
        this.lastWasSixes = lastWasSixes;
    }
}
