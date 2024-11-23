package org.lowlevelDesign.Dice;

public abstract class Dice {

    private final int sides;

    public Dice() {
        this.sides = getSides();
    }

    protected abstract int getSides();

    public int roll() {
        return (int) (Math.random() * sides) + 1;
    }
}
