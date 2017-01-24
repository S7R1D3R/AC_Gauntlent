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

    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Type of graphical grid
     */
    private GridType gridType;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * GameObjects: First element is the Obstacle/Walls, second is the Player
     */
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
    //TODO: Incomplete
    public void init() {

        grid.init();

        // First object to be created are the walls, then create all other characters using that info in the constructor
        this.gameObjects[0] = GameObjFactory.makeObstacles(grid);

        // Second object is the player
        this.gameObjects[1] = GameObjFactory.getNewGameObj(grid, GameObjType.PLAYER, gameObjects[0].getWallsPositions); //TODO: Merge Peter's branch and see if getWallsPositions is working

        // Next elements are the enemies
        int NUM_ENEMIES = 7; // TODO: Property?, argument to the game?
        for (int i = 2; i < NUM_ENEMIES+2; i++) {
            this.gameObjects[i] = GameObjFactory.getNewGameObj(grid, GameObjType.ENEMY, gameObjects[0].getWallsPositions);
        }

        //TODO: Add potions and poisons and princess and end game here. How many?

        // While the game hasn't ended
        while (!isGameFinished) { //TODO: Create this boolean, include delay
            // Loop through movable objects
            for (int i = 0; i < this.gameObjects.length; i++) {

                if (this.gameObjects[i] instanceof Movable) {
                    ((Movable) this.gameObjects[i]).move();
                }
            }
        }



    }

    public static void endGame() {
        // TODO: (GIULIANO): We are using a boolean isGameFinished so this function should some how modify it. What should we put inside this function? Princess? Life? Should we return the boolean or should this method change a boolean property?

    }

}
