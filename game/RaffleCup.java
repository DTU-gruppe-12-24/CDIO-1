package game;

public class RaffleCup {
    private Die[] dice;

    public RaffleCup() {
        dice = new Die[2];
        dice[0] = new Die(); 
        dice[1] = new Die();
    }

    public int getValue(int index) {
        return dice[index].getFaceValue();
    }

    public void roll() {
        dice[0].roll();
        dice[1].roll();
    }

    public int getSum() {
        return dice[0].getFaceValue() + dice[1].getFaceValue();
    }

    public boolean isSame() {
        return dice[0].getFaceValue() == dice[1].getFaceValue();
    }
}
