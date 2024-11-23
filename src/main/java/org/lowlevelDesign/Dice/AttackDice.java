package org.lowlevelDesign.Dice;

public class AttackDice extends Dice {

    private final int ATTACK_DICE_SIDES = 6;

    public AttackDice() {
        super();
    }

    @Override
    public int getSides() {
        return ATTACK_DICE_SIDES;
    }
}
