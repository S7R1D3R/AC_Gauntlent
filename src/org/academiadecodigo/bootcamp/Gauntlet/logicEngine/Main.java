package org.academiadecodigo.bootcamp.Gauntlet.logicEngine;

import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;

/**
 * Created by codecadet on 27/01/17.
 */
public class Main {

    public static void main(String[] args) {

        int gridCols = 42;
        int gridRows = 18;
        int delay = 300;

        Game game = new Game(GridType.SIMPLE_GFX, gridCols, gridRows, delay);

        game.init(1);

        try {
            game.start();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
