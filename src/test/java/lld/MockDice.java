package lld;

import org.lowlevelDesign.Dice.Dice;

public class MockDice extends Dice {

    private final int[] rolls;
    private int currentRoll = 0;

    public MockDice(int... rolls) {
        this.rolls = rolls;
    }

    @Override
    protected int getSides() {
        return 6;
    }

    @Override
    public int roll() {
        return rolls[currentRoll++ % rolls.length];
    }
}
