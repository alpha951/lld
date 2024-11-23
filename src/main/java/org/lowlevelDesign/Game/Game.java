package org.lowlevelDesign.Game;

import org.lowlevelDesign.Dice.Dice;
import org.lowlevelDesign.Dice.DiceFactory;
import org.lowlevelDesign.Dice.DiceType;
import org.lowlevelDesign.entities.Player;

public class Game {

    private final Player player1;

    private final Player player2;

    private  Dice attackDice = DiceFactory.getDice(DiceType.ATTACK);
    private  Dice defendDice = DiceFactory.getDice(DiceType.DEFEND);

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Game(Dice attackDice, Dice defendDice, Player player1, Player player2) {
        this.attackDice = attackDice;
        this.defendDice = defendDice;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Player attacker = player1.getHealth() > player2.getHealth() ? player2 : player1;
        Player defender = attacker == player1 ? player2 : player1;

        int count = 0;
        while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
            playGameRound(attacker, defender);
            attacker = attacker == player1 ? player2 : player1;
            defender = attacker == player1 ? player2 : player1;
            count++;
        }
        if (player1.getHealth() > 0) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 wins");
        }
        System.out.println("Game over after " + count + " rounds");
    }

    private void playGameRound(Player attacker, Player defender) {
        int attackMagnitude = rollAttackDice() * attacker.getAttack();
        int defendMagnitude = rollDefendDice() * defender.getStrength();
        if (attackMagnitude > defendMagnitude) {
            defender.updateHealth(attackMagnitude - defendMagnitude);
        }
    }

    private int rollAttackDice() {
        return attackDice.roll();
    }

    private int rollDefendDice() {
        return defendDice.roll();
    }
}
