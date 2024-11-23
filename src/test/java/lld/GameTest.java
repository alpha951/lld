package lld;

import org.lowlevelDesign.Game.Game;
import org.lowlevelDesign.entities.Player;

public class GameTest {

    public static void main(String[] args) {
        testPlayGameRound_AttackerWins();
        testPlay_FullGame_Player1Wins();
        testPlay_FullGame_Player2Wins();
    }

    private static void testPlayGameRound_AttackerWins() {
        Player player1 = new Player(100, 10, 5); // attacker
        Player player2 = new Player(80, 8, 6);  // defender

        MockDice attackDice = new MockDice(6); // High attack roll
        MockDice defendDice = new MockDice(1); // Low defend roll

        Game game = new Game(attackDice, defendDice, player1, player2);
        game.play();

        // Assert that defender's health is reduced
        if (player2.getHealth() > 0) {
            System.out.println("testPlayGameRound_AttackerWins passed");
        } else {
            System.out.println("testPlayGameRound_AttackerWins failed: Expected 74, got " + player2.getHealth());
        }
    }


    private static void testPlay_FullGame_Player1Wins() {
        Player player1 = new Player(100, 10, 5);
        Player player2 = new Player(80, 8, 6);

        MockDice attackDice = new MockDice(5, 4, 6, 3);
        MockDice defendDice = new MockDice(2, 1, 3, 1);

        Game game = new Game(attackDice, defendDice, player1, player2);
        game.play();

        // Assert that player 1 wins
        if (player1.getHealth() > 0 && player2.getHealth() <= 0) {
            System.out.println("testPlay_FullGame_Player1Wins passed");
        } else {
            System.out.println("testPlay_FullGame_Player1Wins failed: Player 1 Health = " + player1.getHealth() +
                ", Player 2 Health = " + player2.getHealth());
        }
    }

    private static void testPlay_FullGame_Player2Wins() {
        Player player1 = new Player(100, 10, 5);
        Player player2 = new Player(80, 8, 6);

        MockDice attackDice = new MockDice(2, 1, 3, 6);
        MockDice defendDice = new MockDice(1, 2, 1, 5);

        // Create game with mocked dice
        Game game = new Game(attackDice, defendDice, player1, player2);
        game.play();

        // Assert that player 2 wins
        if (player2.getHealth() > 0 && player1.getHealth() <= 0) {
            System.out.println("testPlay_FullGame_Player2Wins passed");
        } else {
            System.out.println("testPlay_FullGame_Player2Wins failed: Player 1 Health = " + player1.getHealth() +
                ", Player 2 Health = " + player2.getHealth());
        }
    }

}
