package org.lowlevelDesign;

import org.lowlevelDesign.Game.Game;
import org.lowlevelDesign.entities.Player;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player(100, 10, 5);
        Player player2 = new Player(50, 5, 10);
        Game game = new Game(player1, player2);
        game.play();
    }
}