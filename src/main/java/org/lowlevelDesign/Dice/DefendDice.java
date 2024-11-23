package org.lowlevelDesign.Dice;

public class DefendDice extends Dice {

    private final int DEFEND_DICE_SIDES = 6;

    public DefendDice() {
        super();
    }

    @Override
    public int getSides() {
        return DEFEND_DICE_SIDES;
    }
}
