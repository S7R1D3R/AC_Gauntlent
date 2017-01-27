package org.academiadecodigo.bootcamp.Gauntlet;

import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;

/**
 * Created by codecadet on 27/01/17.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game(GridType.SIMPLE_GFX, 42, 18, 200);


        game.init(1);

        try {
            game.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
