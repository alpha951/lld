package org.lowlevelDesign.Dice;

public class DiceFactory {

    public static Dice getDice(DiceType diceType) {
        if (diceType.equals(DiceType.ATTACK)) {
            return new AttackDice();
        } else if (diceType.equals(DiceType.DEFEND)) {
            return new DefendDice();
        }
        return null;
    }
}
