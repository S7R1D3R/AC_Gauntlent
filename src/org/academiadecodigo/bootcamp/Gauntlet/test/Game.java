package org.academiadecodigo.bootcamp.Gauntlet.test;

import org.academiadecodigo.bootcamp.Gauntlet.ActionDetector;
import org.academiadecodigo.bootcamp.Gauntlet.LevelMaker;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjFactory;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Movable;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.GridType;

import java.util.ArrayList;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Game {

    private Grid grid;
    private GridType gridType;
    private int delay;
    private ArrayList<GameObject> gameObjects; //NOW ARRAYLIST<GAMEOBJECT> INSTEAD OF GAMEOBJECT[]
    private ActionDetector actionDetector;
    private LevelMaker levelMaker;
    private boolean gameOver;


    /**
     * Constructs a new game
     */
    public Game(GridType gridType, int cols, int rows, int delay) {

        this.grid = GameObjFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
        this.gridType = gridType;
    }


    /**
     * Create game objects in defined positions by the levelMaker
     */

    public void init(int level) {

        // Initializes the grid.
        grid.init();

        // Initializes (and draws) all objects.
        initializeGameObjects(level);

        // Creates ActionDetector
        actionDetector = new ActionDetector(gameObjects);

        // Sets action detector on Movable objects
        for (Movable movableObject : actionDetector.getMovableObjects()) {
            movableObject.setActionDetector(actionDetector);
        }


    }

    /**
     * starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (!gameOver) {

            // Pause for a while
            Thread.sleep(delay);

            moveMovableObjects();
        }
    }

    /**
     * Move all movable objects
     */
    private void moveMovableObjects() {

        for (Movable movableObject : actionDetector.getMovableObjects()) {
            movableObject.move();
        }
    }


    /**
     * ENDS GAME BY SETTING EXIT CONDITION USED ON GAME LOOP TO TRUE
     */
    public void endGame() {
        gameOver = true;
    }

    /**
     * Instances the Level Maker and the ArrayList with all the GameObjects
     * @param level
     */
    private void initializeGameObjects(int level) {

        levelMaker = new LevelMaker(grid);          //Instances the level maker
        gameObjects = levelMaker.getLevel(level);   //Creates the ArrayList with all the gameobjects using the level maker
    }
}



