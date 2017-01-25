package org.academiadecodigo.bootcamp.Gauntlet.test;

import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Game {

    private Grid grid;
    private GridType gridType;
    private int delay;
    private GameObject[] gameObjects;

    /**
     * Constructs a new game
     */
    public Game(GridType gridType, int cols, int rows, int delay) {

        grid = GameObjFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
        this.gridType = gridType;
    }


    /**
     * Create game objects and add a grid
     */

    public void init() {

        // Initializes the grid.
        grid.init();

        // Draws all objects.
        for (int i = 0; i < gameObjects.length; i++) {
              // MAKE THIS METHOD TO LOAD ALL THE IMAGES.
        }
    }

    public static void endGame() {
        // TODO: (GIULIANO): We are using a boolean isGameFinished so this function should some how modify it. What should we put inside this function? Princess? Life? Should we return the boolean or should this method change a boolean property?

    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

}
